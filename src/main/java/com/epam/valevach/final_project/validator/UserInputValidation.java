package com.epam.valevach.final_project.validator;

public class UserInputValidation {
    public static UserInputValidation instance;
    private static final int voidInput = 0;
    private static final int maxInput = 15;

    private UserInputValidation(){}

    public static UserInputValidation getInstance(){
        synchronized (UserInputValidation.class) {
            if (instance == null) {
                instance = new UserInputValidation();
            }
        }
        return instance;
    }

    public boolean checkLengthLimit(String userInput){
        return userInput.length() != voidInput && userInput.length() <= maxInput;
    }
    public boolean checkNotNull(String userInput){
        return userInput.equals("");
    }
}
