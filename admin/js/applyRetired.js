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
                        <td>${conscription.retiredId}</td>
                        <td>${studentName}</td>
                        <td>${adminName}</td>
                        <td>${conscription.retiredTime}</td>
                        <td>${conscription.state}</td>
                        <td>${conscription.remark}</td>
                        <td>
                            <input type="button" value="同意" onclick="approveApply(${conscription.retiredId})">
                            <input type="button" value="拒绝" onclick="refuseApply(${conscription.retiredId})">
                        </td>
                    </tr>
                `;

                // 将生成的 HTML 插入到 id 为 "tab1" 的元素中
                document.getElementById('tab1').insertAdjacentHTML('beforeend', row);

            })
        
    })
}

function getApplyConscriptionInfo() {
    // 获取 conscription 数据
    fetch('http://localhost:8088/retired')
        .then(response => response.json())
        .then(conscriptionData => {
            // 遍历 conscription 数据
            for (let i = 0; i < conscriptionData.data.length; i++) {
                const conscription = conscriptionData.data[i];
                if(conscription.state!='Y'&&conscription.state!='N'){
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


function refuseApply(conscriptionId){
    
    // 要更新的数据

    fetch(`http://localhost:8088/retired/${conscriptionId}`)
        .then(response => response.json())
        .then(conscriptionData => {
            const updatedData = {
                adminId: conscriptionData.data.adminId,
                studentId: conscriptionData.data.studentId,
                state: "N",
                retiredTime: conscriptionData.data.retiredTime,
                remark: conscriptionData.data.remark
            };
            // 使用 PUT 方法更新资源
            fetch(`http://localhost:8088/retired/${conscriptionId}`, {
                method: 'PUT', // 指定请求方法为 PUT
                headers: {
                    'Content-Type': 'application/json' // 设置请求头为 JSON 格式
                },
                body: JSON.stringify(updatedData) // 将数据转换为 JSON 字符串
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json(); // 解析响应数据
                })
                .then(data => {
                    console.log('Update successful:', data); // 处理成功响应
                    alert('拒绝成功');
                })
                .catch(error => {
                    console.error('Error updating data:', error); // 处理错误
                });
                    })
}



function approveApply(conscriptionId){
    
    // 要更新的数据

    fetch(`http://localhost:8088/retired/${conscriptionId}`)
        .then(response => response.json())
        .then(conscriptionData => {
            const updatedData = {
                adminId: conscriptionData.data.adminId,
                studentId: conscriptionData.data.studentId,
                intention: conscriptionData.data.intention,
                state: "Y",
                retiredTime: conscriptionData.data.retiredTime,
                remark: conscriptionData.data.remark
            };
            // 使用 PUT 方法更新资源
            fetch(`http://localhost:8088/retired/${conscriptionId}`, {
                method: 'PUT', // 指定请求方法为 PUT
                headers: {
                    'Content-Type': 'application/json' // 设置请求头为 JSON 格式
                },
                body: JSON.stringify(updatedData) // 将数据转换为 JSON 字符串
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json(); // 解析响应数据
                })
                .then(data => {
                    console.log('Update successful:', data); // 处理成功响应
                    alert('批准成功');
                })
                .catch(error => {
                    console.error('Error updating data:', error); // 处理错误
                });
                    })
}