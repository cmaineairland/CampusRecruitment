function addRow(conscription){
    fetch(`http://localhost:8088/student/${conscription.studentId}`)
    .then(response => response.json())
    .then(studentData => {
        fetch(`http://localhost:8088/admin/${conscription.adminId}`)
            .then(response => response.json())
            .then(adminData => {
                const studentName = studentData.data.studentName;
                const adminName = adminData.data.adminName;
                // 将学生信息转换为指定的 HTML 格式
                const row = `
                    <tr>
                        <td>${conscription.conscriptionId}</td>
                        <td>${studentName}</td>
                        <td>${adminName}</td>
                        <td>${conscription.intention}</td>
                        <td>${conscription.conscriptionTime}</td>
                        <td>${conscription.state}</td>
                        <td>${conscription.remark}</td>
                        
                    </tr>
                `;

                // 将生成的 HTML 插入到 id 为 "tab1" 的元素中
                document.getElementById('tab1').insertAdjacentHTML('beforeend', row);

            })
        
    })
}

function getApplyConscriptionInfo() {
    // 获取 conscription 数据
    fetch('http://localhost:8088/conscription')
        .then(response => response.json())
        .then(conscriptionData => {
            // 遍历 conscription 数据
            for (let i = 0; i < conscriptionData.data.length; i++) {
                const conscription = conscriptionData.data[i];
                if(conscription.state=='Y'||conscription.state=='N'){
                    addRow(conscription);
                }
            }    
        })
        .catch(error => {
            console.error('Error fetching conscription data:', error);
        });
}

// 调用函数
getApplyConscriptionInfo();