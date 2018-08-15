package com.shunan.zhang.test.service;

import com.shunan.zhang.test.BaseTest;
import com.shunanzhang.entity.PersonInfo;
import com.shunanzhang.service.IPersonService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class IPersonServiceTest extends BaseTest {
    @Autowired
    IPersonService personService;
    @Test
    public void addCustomerTest() {
        PersonInfo personInfoinfo = new PersonInfo();
        personInfoinfo.setPersonName("zhang");
        personInfoinfo.setPassWord("111111");
        personInfoinfo.setGender(1);
        personInfoinfo.setCreateTime(new Date());
        personInfoinfo.setLastEditTime(new Date());
        personService.addCustomerInfo(personInfoinfo);
    }
}
