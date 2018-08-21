package com.shunanzhang.service.impl;

import com.shunanzhang.dao.IPersonDao;
import com.shunanzhang.entity.PersonInfo;
import com.shunanzhang.service.IPersonService;
import com.shunanzhang.web.TaskController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private IPersonDao personDao;

    @Override
    public PersonInfo getCustomerInfo(Long personId) {

        PersonInfo personInfo = null;
        try {
            personInfo = personDao.queryPersonInfoById(personId);
            logger.info("query customer info:{}", personInfo);
        } catch (Exception e) {
            logger.error("query customer info error;{}", e);
        }

        return personInfo;
    }

    @Override
    public long addCustomerInfo(PersonInfo personInfo) {
        int effectNum = -1;
        logger.info("insert customer info:{}", personInfo);
        try {
            effectNum = personDao.insertPersonInfo(personInfo);
            if (effectNum < 1) {
                logger.info("insert customer info failed");
                return -1;
            }
        } catch (Exception e) {
            logger.error("insert customer info error:{}", e);
        }
        return personInfo.getPersonId();
    }

    @Override
    public int updateCustomerInfo(PersonInfo personInfo) {
        int effectNum = -1;
        logger.info("update customer info:{}", personInfo);
        try {
            effectNum = personDao.updatePersonInfo(personInfo);
            if (effectNum < 1) {
                logger.info("update customer info failed");
                return -1;
            }
        } catch (Exception e) {
            logger.error("update customer info error;{}", e);
        }
        return effectNum;
    }

    @Override
    public int deleteCustomerInfo(Long personId) {

        int effectNum = -1;
        logger.info("dlete customer info,the customer id:{}", personId);
        try {
            effectNum = personDao.deletePersonInfo(personId);
            if (effectNum < 1) {
                logger.info("delete customer info failed");
                return -1;
            }
        } catch (Exception e) {
            logger.error("delete customer info error;{}", e);
        }
        return effectNum;
    }

    @Override
    public List<PersonInfo> getCustomerInfoList(PersonInfo personCondition, int rowIndex, int pageSize) {
        List<PersonInfo> customerInfoResults = null;
        logger.info("get customer info list,the personCondition : {}, the rowIndex :{},the pageSize:{}",
                personCondition, rowIndex, pageSize);
        try {
            customerInfoResults = personDao.getPersonInfoList(personCondition, rowIndex, pageSize);
        } catch (Exception e) {
            logger.error("get customer info list error;{}", e);
        }
        return customerInfoResults;
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    public int insertCusyomerInfoList(List<PersonInfo>personInfoList){
        int effectNum=-1;
        int count=0;
        if(personInfoList==null||personInfoList.size()==0){
            return count;
        }
        try{
            for(PersonInfo personInfo:personInfoList){
                effectNum=personDao.insertPersonInfo(personInfo);
               if(effectNum<1){
                    throw new RuntimeException("insert insertCusyomerInfoList failed");
               }
                count++;
            }

        }catch(Exception e){
              logger.error("insert insertCusyomerInfoList error:{}",e);
        }
        return count;

    }
}
