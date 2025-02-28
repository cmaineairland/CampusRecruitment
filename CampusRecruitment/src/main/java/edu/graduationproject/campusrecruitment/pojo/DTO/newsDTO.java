package edu.graduationproject.campusrecruitment.pojo.DTO;

public class newsDTO {
    private int newsId;
    private String title;
    private String url;
    private String time;

    // 无参构造函数
    public newsDTO() {
    }

    // 有参构造函数
    public newsDTO(int newsId, String title, String url, String time) {
        this.newsId = newsId;
        this.title = title;
        this.url = url;
        this.time = time;
    }

    // 获取 newsId 的方法
    public int getNewsId() {
        return newsId;
    }

    // 设置 newsId 的方法
    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    // 获取 title 的方法
    public String getTitle() {
        return title;
    }

    // 设置 title 的方法
    public void setTitle(String title) {
        this.title = title;
    }

    // 获取 url 的方法
    public String getUrl() {
        return url;
    }

    // 设置 url 的方法
    public void setUrl(String url) {
        this.url = url;
    }

    // 获取 time 的方法
    public String getTime() {
        return time;
    }

    // 设置 time 的方法
    public void setTime(String time) {
        this.time = time;
    }
}