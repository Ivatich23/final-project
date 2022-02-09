/*
package com.epam.valevach.final_project.service.validation;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Validator {
    public static final Map<ErrorList, String> message = new ConcurrentHashMap<>((Map<? extends ErrorList, ? extends String>) Arrays
            .asList(ErrorList.REGISTRATION_ERROR, ErrorList.REGISTRATION_ERROR.getMassage(),
                    ErrorList.LOGIN_ERROR, ErrorList.LOGIN_ERROR.getMassage(),
                    ErrorList.INPUT_ERROR, ErrorList.INPUT_ERROR.getMassage()));
    private static Validator instance;

    private Validator() {
    }

    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    public String checkRegistration(String stringValue) {
        if (stringValue.length() <= 3) {
            return message.get(ErrorList.REGISTRATION_ERROR);
        }
        return "";
    }

    public String checkLogInStringValue(String stringValue) {
        if(){
            return message.get(ErrorList.LOGIN_ERROR);
        }
    }

    public String checkLogInIntValue(int intValue) {
        if(){
            return message.get(ErrorList.INPUT_ERROR);
        }
    }

}
*/
