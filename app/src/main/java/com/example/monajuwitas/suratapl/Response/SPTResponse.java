package com.example.monajuwitas.suratapl.Response;

import com.example.monajuwitas.suratapl.Model.SPTModel;

import java.util.List;

public class SPTResponse {
    String response_code,status;
    List<SPTModel> data ;

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

    public List<SPTModel> getData() {
        return data;
    }

    public void setData(List<SPTModel> data) {
        this.data = data;
    }
}
