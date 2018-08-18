package com.shunanzhang.valid.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyEmailValidation implements ConstraintValidator<MyEmail, String> {
    @Override
    public void initialize(MyEmail annotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {//校验逻辑
         if(s==null)
             return false;
         return s.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$");
    }

}
