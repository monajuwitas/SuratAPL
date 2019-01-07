package com.example.monajuwitas.suratapl.Response;

import com.example.monajuwitas.suratapl.Model.NDModel;

import java.util.List;

public class NDResponse {
    String response_code,status;
    List<NDModel> data ;

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<NDModel> getData() {
        return data;
    }

    public void setData(List<NDModel> data) {
        this.data = data;
    }
}
