package edu.graduationproject.campusrecruitment.pojo;

public class responseMessage<T> {

    private String message;
    private T data;
    private boolean success;

    // 构造器
    public responseMessage(String message, T data, boolean success) {
        this.message = message;
        this.data = data;
        this.success = success;
    }

    // 静态方法：成功的响应
    public static <T> responseMessage<T> success(T data) {
        return new responseMessage<>("Request successful", data, true);
    }

    // 静态方法：失败的响应
    public static <T> responseMessage<T> error(String message) {
        return new responseMessage<>(message, null, false);
    }

    // Getter 和 Setter 方法
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
