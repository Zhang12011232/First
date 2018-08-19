package com.shunan.zhang.test.valid;

import com.shunan.zhang.test.BaseTest;
import com.shunanzhang.entity.PersonInfo;
import com.shunanzhang.valid.group.GroupA;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.junit.Test;

import javax.validation.*;
import java.util.Set;

public class PersonInfoValidTest extends BaseTest {
    @Test
    public void validPersonInfo(){
        PersonInfo personInfo=new PersonInfo();
       // personInfo.setPersonName("zh");
      //  personInfo.setPassWord("zas");
     //   personInfo.seteMail("1234");
        Configuration<HibernateValidatorConfiguration> config =
                Validation.byProvider(HibernateValidator.class).configure();
        ValidatorFactory vf = config.buildValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<PersonInfo>> set = validator.validate(personInfo,GroupA.class);
        for (ConstraintViolation<PersonInfo> constraintViolation : set) {
            System.out.println(constraintViolation.getMessage());
        }

    }
}
