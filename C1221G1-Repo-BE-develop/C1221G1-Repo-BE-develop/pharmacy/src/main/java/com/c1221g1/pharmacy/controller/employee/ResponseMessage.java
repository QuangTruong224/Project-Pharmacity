package com.c1221g1.pharmacy.controller.employee;

import java.util.List;
import java.util.Map;

public class ResponseMessage<T> {
    private boolean status;
    private String message;
    private Map<String, String> errorMap;
    private List<T> data;


    public ResponseMessage() {
    }
    /*
      Created by TamNA
      Time: 12:50:00 03/07/2022
      Function:  return list field errors Employee
 */
    public ResponseMessage(boolean status, String message, Map<String, String> errorMap, List<T> data) {
        this.status = status;
        this.message = message;
        this.errorMap = errorMap;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


}
