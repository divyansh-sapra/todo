package com.example.todo.utils;

import java.sql.Array;

public class ApiResponse<T> {
    private String successResponse;
    private String errorResponse;
    private T data;

    public String getSuccessResponse() {
        return successResponse;
    }

    public void setSuccessResponse(String successResponse) {
        this.successResponse = successResponse;
    }

    public String getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(String errorResponse) {
        this.errorResponse = errorResponse;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiResponse(String successResponse, String errorResponse, T data) {
        this.successResponse = successResponse;
        this.errorResponse = errorResponse;
        this.data = data;
    }

    public ApiResponse(String successResponse, String errorResponse) {
        this.successResponse = successResponse;
        this.errorResponse = errorResponse;
    }
}
