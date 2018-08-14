package com.shunanzhang.service.impl;

import com.shunanzhang.dao.IPersonDao;
import com.shunanzhang.entity.PersonInfo;
import com.shunanzhang.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {
    @Autowired
    IPersonDao personDao;

    @Override
    public PersonInfo getCustomerInfo(Long personId) {

        PersonInfo personInfo = personDao.queryPersonInfoById(personId);


        return personInfo;
    }

    @Override
    public long addCustomer(PersonInfo personInfo) {
        int effectNum = -1;

        effectNum = personDao.insertPersonInfo(personInfo);

        return personInfo.getPersonId();
    }

    @Override
    public int modifyCustomerInfo(PersonInfo personInfo) {
        int effectNum = -1;

        effectNum =personDao.updatePersonInfo(personInfo);

        return effectNum;
    }

    @Override
    public int deleteCustomer(Long personId) {

        int effectNum = -1;

        effectNum = personDao.deletePersonInfo(personId);

        return effectNum;
    }

    @Override
    public List<PersonInfo> getCustomerInfoList(PersonInfo personCondition, int rowIndex, int pageSize) {
        List<PersonInfo> customerInfoResults = null;

        customerInfoResults = personDao.getPersonInfoList(personCondition, rowIndex, pageSize);

        return customerInfoResults;
    }
}
