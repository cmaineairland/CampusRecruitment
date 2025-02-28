function getAdminInfo(){
    // 使用fetch方法获取数据
    fetch('http://localhost:8088/admin')
    .then(response => response.json()) // 将响应解析为JSON
    .then(data => {
        // 获取data数组中的第一个学生信息
        for (let i = 0; i < data.data.length; i++) {
            const admin = data.data[i];

        // 将学生信息转换为指定的HTML格式
        const row = `
            <tr>
                <td>${admin.adminId}</td>
                <td>${admin.adminName}</td>
                <td>${admin.workplace}</td>
            </tr>
        `;

        // 将生成的HTML插入到id为“studentInfo”的元素中
        document.getElementById('tab1').insertAdjacentHTML('beforeend', row);

        }
        
    })
    .catch(error => {
        console.error('Error fetching data:', error);
    });
}

getAdminInfo()