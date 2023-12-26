package com.maxi.backschool.services.exceptions;

public class StandardError {

    private Integer status;
    private Long moment;
    private String errorMessage;

    public StandardError() {
    }

    public StandardError(Long moment, Integer status, String errorMessage) {
        this.status = status;
        this.moment = moment;
        this.errorMessage = errorMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getMoment() {
        return moment;
    }

    public void setMoment(Long moment) {
        this.moment = moment;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
