package com.shunan.zhang.test.service;

import com.shunan.zhang.test.BaseTest;
import com.shunanzhang.entity.PersonInfo;
import com.shunanzhang.enums.SexEnum;
import com.shunanzhang.service.IPersonService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IPersonServiceTest extends BaseTest {
    @Autowired
    IPersonService personService;

    @Ignore
    @Test
    public void addCustomerTest() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setPersonName("zhang");
        personInfo.setPassWord("111111");
        SexEnum gender=SexEnum.getSexById(1);
        personInfo.setGender(gender);;
        personInfo.setCreateTime(new Date());
        personInfo.setLastEditTime(new Date());
        personService.addCustomerInfo(personInfo);
    }

    @Ignore
    @Test
    public void getCustomerInfoTest() {
        PersonInfo perinfo = personService.getCustomerInfo(12L);
        System.out.println(perinfo.getPersonName());
    }

    @Ignore
    @Test
    public void updateCustomerInfoTest() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setPersonName("shunan.zhang");
        personInfo.seteMail("qq.com");
        personInfo.setPhone("123456");
        SexEnum gender=SexEnum.getSexById(1);
        personInfo.setGender(gender);
        personInfo.setPersonId(12L);
        personInfo.setLastEditTime(new Date());
        int effectNum = personService.updateCustomerInfo(personInfo);
        System.out.println(effectNum);
    }

    @Test
    public void deleteCustomer() {
        int effectNum = personService.deleteCustomerInfo(13L);
        System.out.println(effectNum);
    }

    @Ignore
    @Test
    public void getCustomerInfoListTest() {
        PersonInfo personInfo = new PersonInfo();
        SexEnum gender=SexEnum.getSexById(1);
        personInfo.setGender(gender);
        personInfo.setPersonName("zh");
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date dt = null;
        String dateStringToParse = "8-15-2018";
        try {
            dt = bartDateFormat.parse(dateStringToParse);
        } catch (Exception e) {

        }
        //System.out.println("date"+dt);
        personInfo.setCreateTime(dt);
        List<PersonInfo> results = personService.getCustomerInfoList(personInfo, 0, 2);
    }

 //   @Ignore
    @Test
    public void insertCustomerInfoListTest() {
        List<PersonInfo> personInfoList = new ArrayList<PersonInfo>();
        PersonInfo personInfo1 = new PersonInfo();
        personInfo1.setPersonName("zhang");
        personInfo1.setPassWord("111111");
        SexEnum gender=SexEnum.getSexById(1);
        personInfo1.setGender(gender);
        personInfo1.setCreateTime(new Date());
        personInfo1.setLastEditTime(new Date());
        PersonInfo personInfo2 = new PersonInfo();
        personInfo2.setPersonName("nan");
        personInfo2.setPassWord("12011232");
         gender=SexEnum.getSexById(0);
        personInfo2.setGender(gender);
        personInfo2.setCreateTime(new Date());
        personInfo2.setLastEditTime(new Date());
        personInfoList.add(personInfo1);
        personInfoList.add(personInfo2);
        personService.insertCusyomerInfoList(personInfoList);
    }
}
