package com.systemRealEstate.systemRealEstate.controller.DTO;

public class errorDTO {
    private String message;
    private String information;
    private String status;

    public errorDTO() {
    }

    public errorDTO(String message, String information, String status) {
        this.message = message;
        this.information = information;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
