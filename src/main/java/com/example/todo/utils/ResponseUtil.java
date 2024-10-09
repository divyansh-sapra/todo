package com.example.todo.utils;

public class ResponseUtil {
    public static <T> ApiResponse<T> successResponse() {
        return new ApiResponse<>("SUCCESS", "");
    }

    public static <T> ApiResponse<T> successResponseWithData(T data) {
        return new ApiResponse<>("SUCCESS", "", data);
    }

    public static <T> ApiResponse<T> errorResponse(String errorMessage) {
        return new ApiResponse<>("", errorMessage, null);
    }
}
