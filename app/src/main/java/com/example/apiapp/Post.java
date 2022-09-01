package com.example.apiapp;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("ErrorMessage")
    private String message;

    @SerializedName("ErrorType")
    private String errorType;

    @SerializedName("RequestId")
    private String requestId;

    @SerializedName("TimeStamp")
    private String time;


    public String getMessage() {
        return message;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getTime() {
        return time;
    }


}
