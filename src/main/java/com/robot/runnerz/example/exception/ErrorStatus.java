package com.robot.runnerz.example.exception;

public enum ErrorStatus {
    USER_NOT_FOUND(404, "User not found");

    final int errorCode;

    final String errorMessage;


    ErrorStatus(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {return this.errorCode;}
    public String getErrorMessage() {return this.errorMessage;}
}
