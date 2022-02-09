package com.epam.valevach.final_project.validator;

public class EmployeeDeleteValidation {
    public static EmployeeDeleteValidation instance;


    private EmployeeDeleteValidation(){}

    public static EmployeeDeleteValidation getInstance(){
        synchronized (EmployeeDeleteValidation.class) {
            if (instance == null) {
                instance = new EmployeeDeleteValidation();
            }
        }
        return instance;
    }

    public boolean checkEqualsZero(String entity){
        return entity.equals("0");
    }

}
