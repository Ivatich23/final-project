package com.epam.valevach.final_project.service.validation;

public enum ErrorList {
    REGISTRATION_ERROR("Incorrect registration values,please,try again"),
    LOGIN_ERROR("Incorrect login values,please,try again"),
    INPUT_ERROR("Incorrect input,please,try again");
   private String massage;

    ErrorList(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}
