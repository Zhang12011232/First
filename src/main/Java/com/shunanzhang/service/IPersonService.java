package com.shunanzhang.service;

import com.shunanzhang.entity.PersonInfo;

import java.util.List;

public interface IPersonService {
    PersonInfo getCustomerInfo(Long personId);

    long addCustomer(PersonInfo personInfo);

    int modifyCustomerInfo(PersonInfo personInfo);

    int deleteCustomer(Long personId);

    List<PersonInfo> getCustomerInfoList(PersonInfo personCondition, int rowIndex, int pageSize);
}
