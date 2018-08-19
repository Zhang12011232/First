package com.shunanzhang.valid.validation.hanlder;

import com.shunanzhang.valid.validation.annotation.EmaiFormatl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyEmailValidation implements ConstraintValidator<EmaiFormatl, String> {
    @Override
    public void initialize(EmaiFormatl annotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {//校验逻辑
         if(s==null)
             return false;
         return s.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$");
    }

}
