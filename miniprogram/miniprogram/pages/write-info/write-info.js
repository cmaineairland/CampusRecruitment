Page({
  data: {
    studentName: '',
    phoneNumber: '',
    enterSchoolYear: '',
    college: '',
    photo: '',
    major: '',
    class: '',
    ethnic: '',
    political: '',
    address: '',
    ethnicList: [
      '汉族', '蒙古族', '回族', '藏族', '维吾尔族', '苗族', '彝族', '壮族', '布依族', '朝鲜族', 
      '满族', '侗族', '瑶族', '白族', '土家族', '哈尼族', '哈萨克族', '傣族', '黎族', '傈僳族', 
      '佤族', '畲族', '高山族', '拉祜族', '水族', '东乡族', '纳西族', '景颇族', '柯尔克孜族', '土族', 
      '达斡尔族', '仫佬族', '羌族', '布朗族', '撒拉族', '毛南族', '仡佬族', '锦族', '契丹族', '鄂温克族', 
      '怒族', '乌孜别克族', '俄罗斯族', '鄂伦春族', '德昂族', '保安族', '裕固族', '京族', '塔吉克族', 
      '独龙族', '阿昌族', '普米族', '塔塔尔族', '赫哲族', '门巴族', '珞巴族', '基诺族', '乌尔基克族'
    ],
    politicalList: [
      '中国共产党党员', '共青团员', '群众', '中国共产党预备党员', '其他'
    ],
    ethnicIndex: 0,  // 默认选中第一个民族
    politicalIndex: 0,  // 默认选中第一个政治面貌
    responseMessage: ''
  },
  choosePhoto() {
    wx.chooseImage({
      count: 1,
      sizeType: ['compressed'],
      sourceType: ['album', 'camera'],
      success: (res) => {
        this.setData({
          photo: res.tempFilePaths[0]
        });
      }
    });
  },
  onEthnicChange: function (e) {
    this.setData({
      ethnicIndex: e.detail.value,
      ethnic: this.data.ethnicList[e.detail.value]
    });
  },

  onPoliticalChange: function (e) {
    this.setData({
      politicalIndex: e.detail.value,
      political: this.data.politicalList[e.detail.value]
    });
  },

  onInputChange: function (e) {
    const field = e.currentTarget.dataset.field;
    this.setData({
      [field]: e.detail.value
    });
  },
    choosePhoto() {
    wx.chooseImage({
      count: 1,
      sizeType: ['compressed'],
      sourceType: ['album', 'camera'],
      success: (res) => {
        this.setData({
          photo: res.tempFilePaths[0]
        });
      }
    });
  },

  // 提交学生信息
  submitStudentInfo: function () {
    const studentDTO = {
      studentName: this.data.studentName,
      phoneNumber: this.data.phoneNumber,
      enterSchoolYear: this.data.enterSchoolYear,
      college: this.data.college,
      photo: '',
      major: this.data.major,
      studentClass: this.data.class,
      ethnic: this.data.ethnic,
      political: this.data.political,
      address: this.data.address
    };

      
    wx.request({
      url: 'http://localhost:8088/student', // 你的后端接口地址
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      data: studentDTO,
      success: (res) => {
        if (res.data.code === 200) {
          this.setData({
            responseMessage: '学生添加成功！'
          });
        } else {
          this.setData({
            responseMessage: '添加状态: ' + res.data.message
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
