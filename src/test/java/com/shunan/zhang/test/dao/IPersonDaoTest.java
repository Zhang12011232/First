package com.shunan.zhang.test.dao;

import com.shunan.zhang.test.BaseTest;
import com.shunanzhang.dao.IPersonDao;
import com.shunanzhang.entity.PersonInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class IPersonDaoTest extends BaseTest {
    @Autowired
    private IPersonDao IPersonDao;

    @Ignore
    @Test
    public void insertPersonInfo() throws Exception {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setPersonName("zhang");
        personInfo.setPassWord("111111");
        personInfo.setGender(1);
        personInfo.setPhone("18801183907");
        personInfo.seteMail("1404876006@qq.com");
        personInfo.setCreateTime(new Date());
        personInfo.setLastEditTime(new Date());
        IPersonDao.insertPersonInfo(personInfo);
    }

    @Ignore
    @Test
    public void queryPersonInfoById() {
        int x = 0;
        try {
            IPersonDao.queryPersonInfoById(12L);
        } catch (Exception e) {
            System.out.println(e instanceof RuntimeException);
        }
    }

    @Ignore
    @Test
    public void updatePersonInfo() throws Exception {
        PersonInfo perinfo = new PersonInfo();
        perinfo.setPersonId(12L);
        perinfo.setPassWord("12011232");
        int effectnum = IPersonDao.updatePersonInfo(perinfo);
        System.out.print(effectnum);
    }

    @Test
    public void deletePersonInfo() throws Exception {
        IPersonDao.deletePersonInfo(13L);
    }

    @Ignore
    @Test
    public void getPersonInfoTest() {
        PersonInfo perinfo = new PersonInfo();
        perinfo.setGender(1);
        perinfo.setPersonName("zh");
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date dt = null;
        String dateStringToParse = "7-24-2018";
        try {
            dt = bartDateFormat.parse(dateStringToParse);
        } catch (Exception e) {

        }
        System.out.println("date" + dt);
        perinfo.setCreateTime(dt);
        List<PersonInfo> results = IPersonDao.getPersonInfoList(perinfo, 0, 2);
        List<PersonInfo> results2 = IPersonDao.getPersonInfoList(perinfo, 2, 2);

    }
}
