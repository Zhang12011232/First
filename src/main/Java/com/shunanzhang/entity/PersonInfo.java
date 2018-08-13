package com.shunanzhang.entity;


import java.util.Date;

/**
 * Created by shunan.zhang on 2018/7/20.
 */
public class PersonInfo {
    private long personId;
    private String personName;
    private String passWord;
    private Integer gender;
    private Date createTime;
    private Date lastEditTime;

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setCreateTime(Date createTime) {this.createTime = createTime;}

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getPersonId() {return personId;}

    public String getPersonName() {
        return personName;
    }

    public String getPassWord() {
        return passWord;
    }

    public Integer getGender() {
        return gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }
}

