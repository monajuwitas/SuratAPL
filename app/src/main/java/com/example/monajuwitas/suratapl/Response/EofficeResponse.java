package com.example.monajuwitas.suratapl.Response;

import com.example.monajuwitas.suratapl.Model.EofficeModel;

import java.util.List;

public class EofficeResponse {
    String response_code,status;
    List<EofficeModel> data ;

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

    public List<EofficeModel> getData() {
        return data;
    }

    public void setData(List<EofficeModel> data) {
        this.data = data;
    }
}
