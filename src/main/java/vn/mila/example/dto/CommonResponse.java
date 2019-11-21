package vn.mila.example.dto;

import com.google.gson.JsonElement;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 11:58 AM
 */
public class CommonResponse {

    private String code;
    private JsonElement data;

    public String getCode() {
        return code;
    }

    public CommonResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public JsonElement getData() {
        return data;
    }

    public CommonResponse setData(JsonElement data) {
        this.data = data;
        return this;
    }
}
