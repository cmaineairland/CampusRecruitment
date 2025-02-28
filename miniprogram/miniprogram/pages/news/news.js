Page({
  data: {
    newsList: []
  },
  onLoad() {
    this.fetchNews();
  },
  fetchNews() {
    wx.request({
      url: 'http://localhost:8088/news',
      method: 'GET',
      success: (res) => {
        if (res.data.success) {
          this.setData({
            newsList: res.data.data
          });
        }
      },
      fail: (err) => {
        console.error('请求新闻数据失败:', err);
      }
    });
  },
  navigateToNews(event) {
    const url = event.currentTarget.dataset.url;
    wx.navigateTo({
      url: `/pages/webView/webView?url=${encodeURIComponent(url)}`
    });
  }
});