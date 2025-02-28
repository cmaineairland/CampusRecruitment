function setTime() {
    // 获取当前日期
    const currentDate = new Date();

    // 获取当前月份（注意：月份从0开始，所以要加1）
    const currentMonth = currentDate.getMonth() + 1;

    // 获取当前年份
    const currentYear = currentDate.getFullYear();

    // 获取今天是几号
    const currentDay = currentDate.getDate();

    // 获取 ul 元素
    const ul = document.getElementById('days');

    // 将月份和年份插入到对应的 HTML 元素中
    document.getElementById('month').textContent = currentMonth + "月";
    document.getElementById('year').textContent = currentYear;

    // 清空 ul 内容（避免重复添加）

    dayOf1 = (currentDate.getDay()-(currentDay-1)%7+7)%7;
    for (let i = 0; i < dayOf1; i++){
        const li = document.createElement('li');
        li.textContent = " ";
        ul.appendChild(li);
    }
    
    // 循环生成 1 到 31 号的 li 元素
    for (let i = 1; i <= 31; i++) {
        const li = document.createElement('li');

        // 如果是今天的日期，添加 <span class="active">
        if (i === currentDay) {
            const span = document.createElement('span');
            span.className = 'active';
            span.textContent = i;
            li.appendChild(span);
        } else {
            li.textContent = i;
        }

        // 将 li 添加到 ul 中
        ul.appendChild(li);
    }
}

function setNum(){
    const studentNum = document.getElementById('studentNum');
    const adminNum = document.getElementById('adminNum');
    const applyConscriptionNum = document.getElementById('applyConscriptionNum');
    const historyApplyConscriptionNum = document.getElementById('historyApplyConscriptionNum');
    const applyRetiredNum = document.getElementById('applyRetiredNum');
    const historyApplyRetiredNum = document.getElementById('historyApplyRetiredNum');
    
    // 获取学生数量
    fetch('http://localhost:8088/student', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json(); // 解析响应为 JSON
    })
    .then(result => {
        // 获取 data 数组的长度
        const dataLength = result.data.length;
        studentNum.textContent = dataLength;
        console.log('data 中元素的数量:', dataLength);
    })
    .catch(error => {
        console.error('请求失败:', error);
    });

    // 获取管理员数量
    fetch('http://localhost:8088/admin', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json(); // 解析响应为 JSON
    })
    .then(result => {
        // 获取 data 数组的长度
        const dataLength = result.data.length;
        adminNum.textContent = dataLength;
        console.log('data 中元素的数量:', dataLength);
    })
    .catch(error => {
        console.error('请求失败:', error);
    });

        // 获取征兵信息
    fetch('http://localhost:8088/conscription', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json(); // 解析响应为 JSON
    })
    .then(result => {
        // 初始化计数器
        let stateZeroCount = 0;
        let stateNonZeroCount = 0;

        // 遍历 data 数组
        result.data.forEach(item => {
            if (item.state === "0") {
                stateZeroCount++;
            } else {
                stateNonZeroCount++;
            }
        });

        // 输出结果
        console.log('state 为 0 的数量:', stateZeroCount);
        console.log('state 非零的数量:', stateNonZeroCount);

        // 如果需要将结果显示在页面上
        historyApplyConscriptionNum.textContent = stateZeroCount;
        applyConscriptionNum.textContent = stateNonZeroCount;
    })
    .catch(error => {
        console.error('请求失败:', error);
    });

    fetch('http://localhost:8088/retired', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json(); // 解析响应为 JSON
    })
    .then(result => {
        // 初始化计数器
        let stateZeroCount = 0;
        let stateNonZeroCount = 0;

        // 遍历 data 数组
        result.data.forEach(item => {
            if (item.state === "0") {
                stateZeroCount++;
            } else {
                stateNonZeroCount++;
            }
        });

        // 输出结果
        console.log('state 为 0 的数量:', stateZeroCount);
        console.log('state 非零的数量:', stateNonZeroCount);

        // 如果需要将结果显示在页面上
        historyApplyRetiredNum.textContent = stateZeroCount;
        applyRetiredNum.textContent = stateNonZeroCount;
    })
    .catch(error => {
        console.error('请求失败:', error);
    });
}

// 调用函数
setTime();
setNum();