package com.shunan.zhang.test.service;

import com.shunan.zhang.test.BaseTest;
import com.shunanzhang.entity.PersonInfo;
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
        PersonInfo personInfoinfo = new PersonInfo();
        personInfoinfo.setPersonName("zhang");
        personInfoinfo.setPassWord("111111");
        personInfoinfo.setGender(1);
        personInfoinfo.setCreateTime(new Date());
        personInfoinfo.setLastEditTime(new Date());
        personService.addCustomerInfo(personInfoinfo);
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
        PersonInfo perinfo = new PersonInfo();
        perinfo.setPersonName("shunan.zhang");
        perinfo.seteMail("qq.com");
        perinfo.setPhone("123456");
        perinfo.setPersonId(13L);
        perinfo.setLastEditTime(new Date());
        int effectNum = personService.updateCustomerInfo(perinfo);
        System.out.println(effectNum);
    }
    @Test
    public void deleteCustomer() {
        int effectNum = personService.deleteCustomerInfo(13L);
        System.out.println(effectNum);
    }
    @Ignore
    @Test
    public void getCustomerInfoListTest(){
        PersonInfo perinfo = new PersonInfo();
        perinfo.setGender(1);
        perinfo.setPersonName("zh");
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date dt=null;
        String dateStringToParse = "8-15-2018";
        try{
            dt=bartDateFormat.parse(dateStringToParse);
        }catch(Exception e){

        }
        //System.out.println("date"+dt);
        perinfo.setCreateTime(dt);
        List<PersonInfo> results=personService.getCustomerInfoList(perinfo,0,2);
    }
    @Test
    public void insertCustomerInfoListTest(){
        List<PersonInfo>personInfoList=new ArrayList<PersonInfo>();
        PersonInfo personInfo1 = new PersonInfo();
        personInfo1.setPersonName("zhang");
        personInfo1.setPassWord("111111");
        personInfo1.setGender(1);
        personInfo1.setCreateTime(new Date());
        personInfo1.setLastEditTime(new Date());
        PersonInfo personInfo2 = new PersonInfo();
        personInfo2.setPersonName("nan");
        personInfo2.setPassWord("12011232");
        personInfo2.setGender(0);
        personInfo2.setCreateTime(new Date());
        personInfo2.setLastEditTime(new Date());
        personInfoList.add(personInfo1);
        personInfoList.add(personInfo2);
        personService.insertCusyomerInfoList(personInfoList);
    }
}
