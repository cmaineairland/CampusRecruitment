document.addEventListener('DOMContentLoaded', function () {
    const chatHistory = document.getElementById('chatHistory');
    const inputText = document.getElementById('inputText');
    const sendButton = document.getElementById('sendButton');
    let messages = [];
    let intervalId;

    // 从服务器获取聊天历史的函数
    function fetchChatHistory() {
        fetch('http://localhost:8088/cheat')
           .then(response => response.json())
           .then(data => {
                if (data.success) {
                    // 处理从服务器返回的数据，将其转换为消息对象数组
                    messages = data.data.map(item => {
                        return {
                            content: item.sentence,
                            // 判断 role 是否为 admin 或 robot，是则标记为 self，若为 user 则标记为 other
                            isSelf: ['admin', 'robot'].includes(item.role)
                        };
                    });
                    // 渲染聊天历史
                    renderChatHistory();
                }
            })
           .catch(err => console.error('获取聊天历史失败', err));
    }

    // 渲染聊天历史到页面的函数
    function renderChatHistory() {
        // 清空聊天历史区域
        chatHistory.innerHTML = '';
        // 遍历消息数组，为每条消息创建一个 DOM 元素并添加到聊天历史区域
        messages.forEach(message => {
            const messageElement = document.createElement('div');
            messageElement.classList.add('message', message.isSelf ? 'self' : 'other');
            messageElement.textContent = message.content;
            chatHistory.appendChild(messageElement);
        });
    }

    // 发送消息的函数
    function sendMessage() {
        if (inputText.value.trim()!== '') {
            const newMessage = {
                content: inputText.value,
                isSelf: false // 发送的消息标记为 other
            };

            // 发送 POST 请求将消息发送到服务器
            fetch('http://localhost:8088/cheat', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    role: 'admin',
                    sentence: newMessage.content
                })
            })
               .then(response => response.json())
               .then(data => {
                    console.log('数据写入成功', data);
                })
               .catch(err => console.error('数据写入失败', err));

            // 将新消息添加到消息数组中
            messages.push(newMessage);
            // 重新渲染聊天历史
            renderChatHistory();
            // 清空输入框
            inputText.value = '';
        }
    }

    // 为发送按钮添加点击事件监听器，点击时调用 sendMessage 函数
    sendButton.addEventListener('click', sendMessage);
    // 为输入框添加输入事件监听器，可在此处添加处理输入的逻辑
    inputText.addEventListener('input', function () {
        // 这里可以添加类似小程序 onInput 的逻辑，目前未明确需求所以暂未添加
    });

    // 页面加载完成后立即获取一次聊天历史
    fetchChatHistory();
    // 每隔 1 秒获取一次聊天历史
    intervalId = setInterval(fetchChatHistory, 1000);

    // 当窗口即将关闭时，清除定时器
    window.addEventListener('beforeunload', function () {
        clearInterval(intervalId);
    });
});