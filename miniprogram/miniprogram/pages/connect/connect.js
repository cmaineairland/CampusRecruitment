Page({
  data: {
    messages: [],
    inputValue: '',
    intervalId: null // 用于存储定时器 ID
  },
  onLoad: function () {
    // 页面加载时发起 GET 请求获取聊天历史
    this.fetchChatHistory();
    // 每隔一秒获取一次聊天历史
    const intervalId = setInterval(() => {
      this.fetchChatHistory();
    }, 1000);
    this.setData({
      intervalId: intervalId
    });
  },
  onUnload: function () {
    // 页面卸载时清除定时器
    if (this.data.intervalId) {
      clearInterval(this.data.intervalId);
    }
  },
  onInput: function (e) {
    this.setData({
      inputValue: e.detail.value
    });
  },
  sendMessage: function () {
    if (this.data.inputValue.trim()!== '') {
      const newMessage = {
        content: this.data.inputValue,
        isSelf: true
      };

      // 发送请求将内容写入数据库
      wx.request({
        url: 'http://localhost:8088/cheat',
        method: 'POST',
        header: {
          'Content-Type': 'application/json'
        },
        data: {
          role: 'user',
          sentence: newMessage.content
        },
        success: function (res) {
          console.log('数据写入成功', res.data);
        },
        fail: function (err) {
          console.error('数据写入失败', err);
        }
      });

      // 将新消息添加到消息列表
      this.setData({
        messages: [...this.data.messages, newMessage],
        inputValue: '' // 清空输入框内容
      });
    }
  },
  fetchChatHistory: function () {
    wx.request({
      url: 'http://localhost:8088/cheat',
      method: 'GET',
      success: (res) => {
        if (res.data.success) {
          const messages = res.data.data.map(item => {
            return {
              content: item.sentence,
              isSelf: item.role === 'user'
            };
          });
          this.setData({
            messages: messages
          });
        }
      },
      fail: (err) => {
        console.error('获取聊天历史失败', err);
      }
    });
  }
});