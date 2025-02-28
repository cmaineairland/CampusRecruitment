Page({
  // 跳转到页面 1
  goToPageConscription: function () {
    wx.navigateTo({
      url: '/pages/conscription/conscription'  // 目标页面的路径
    });
  },
  goToPageRetire: function () {
    wx.navigateTo({
      url: '/pages/retire/retire'  // 目标页面的路径
    });
  },
  goToPageWriteInfo: function () {
    wx.navigateTo({
      url: '/pages/write-info/write-info'  // 目标页面的路径
    });
  },
});
