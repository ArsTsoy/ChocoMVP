package com.example.arslan.chocomvp2.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonResult<T> {
    @SerializedName("result")
    @Expose
    private T result;

    public T getResult() {
        return result;
    }
}
