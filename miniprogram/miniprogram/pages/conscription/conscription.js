Page({
  data: {
    studentId: '',
    adminId: '',
    intention: '',
    address:'',
    intentionList: [
      '陆军','海军','空军','火箭军','武警','艰苦地区部队','战略支援部队','联勤保障部队'
    ],
    intentionIndex: 0,  // 默认选中第一个军种
    responseMessage: ''
  },
  
 
  onIntentionChange: function (e) {
    this.setData({
      intentionIndex: e.detail.value,
      intention: this.data.intentionList[e.detail.value]
    });
  },

  onInputChange: function (e) {
    const field = e.currentTarget.dataset.field;
    this.setData({
      [field]: e.detail.value
    });
  },
    

  // 提交学生信息
  submitStudentInfo: function () {
        // 获取当前时间
    const currentDate = new Date();

    // 获取当前时间的ISO 8601格式（包括时区信息）
    let isoString = currentDate.toISOString();

    // 替换ISO格式中的 'Z' 为 '+00:00'
    isoString = isoString.replace('Z', '+00:00');
    const conscriptionDTO = {


      studentId: this.data.studentId,
      adminId: this.data.adminId,
      intention: this.data.intention,
      state: "P",
      conscriptionTime: isoString,
      remark: this.data.address
      
    };

      
    wx.request({
      url: 'http://localhost:8088/conscription', // 你的后端接口地址
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      data: conscriptionDTO,
      success: (res) => {
        if (res.data.code === 200) {
          this.setData({
            responseMessage: '报名成功！'
          });
        } else {
          this.setData({
            responseMessage: '报名状态: ' + res.data.message
          });
        }
      },
      fail: (err) => {
        this.setData({
          responseMessage: '请求失败: ' + err.errMsg
        });
      }
    });
  }
});
