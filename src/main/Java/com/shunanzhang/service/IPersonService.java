package com.shunanzhang.service;

import com.shunanzhang.entity.PersonInfo;

import java.util.List;

public interface IPersonService {
    PersonInfo getCustomerInfo(Long personId);

    long addCustomerInfo(PersonInfo personInfo);

    int updateCustomerInfo(PersonInfo personInfo);

    int deleteCustomerInfo(Long personId);

    List<PersonInfo> getCustomerInfoList(PersonInfo personCondition, int rowIndex, int pageSize);

    int insertCusyomerInfoList(List<PersonInfo>personInfoList);
}
