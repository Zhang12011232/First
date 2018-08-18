package com.shunanzhang.entity;


import com.shunanzhang.valid.group.GroupA;
import com.shunanzhang.valid.validation.annotation.MyEmail;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by shunan.zhang on 2018/7/20.
 */
public class PersonInfo {

    private long personId;

    @Size(min=6,max=30,groups = {GroupA.class},message = "the length of name is error")
    private String personName;

    @Size(min=6,max=30,groups = {GroupA.class},message = "the length of password is error")
    private String passWord;

    private String phone;

    @MyEmail(groups = {GroupA.class},message = "the format of email is error")
    private String eMail;

    private Integer gender;
    private Date createTime;
    private Date lastEditTime;

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }


    public long getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPassWord() {
        return passWord;
    }

    public Integer getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String geteMail() {
        return eMail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }
}

