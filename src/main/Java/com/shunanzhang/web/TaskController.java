package com.shunanzhang.web;

import com.shunanzhang.entity.PersonInfo;
import com.shunanzhang.enums.SexEnum;
import com.shunanzhang.service.IPersonService;
import com.shunanzhang.valid.group.Group;
import com.shunanzhang.valid.group.GroupA;
import com.shunanzhang.valid.group.GroupB;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping(value = "task", method = {RequestMethod.GET, RequestMethod.POST})
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private IPersonService iPersonService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    private Map ownerLoginCheck(HttpServletRequest request) {

        Map<String, List<PersonInfo> > result = new HashMap<String, List<PersonInfo>>();
        logger.info("test");
        logger.debug("test");
        logger.error("test");
        List<PersonInfo>personInfoList=new ArrayList<PersonInfo>();
        PersonInfo personInfo1=new  PersonInfo();
        personInfo1.setPersonName("zhang");
        personInfo1.setPassWord("123");
        SexEnum gender=SexEnum.getSexById(1);
        personInfo1.setGender(gender);
        personInfoList.add(personInfo1);

        PersonInfo personInfo2=new  PersonInfo();
        personInfo2.setPersonName("shu");
        personInfo2.setPassWord("12323");
        personInfoList.add(personInfo2);
        result.put("data",personInfoList);
        return result;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    private Map queryCustomeerInfo(@RequestParam("personid") long personId) {
        Map<String, Object> results = new HashMap<String, Object>();
        PersonInfo personInfo = iPersonService.getCustomerInfo(personId);
        if (personInfo == null) {
            logger.info("query customer info failed ,customer :{}", personInfo);
            results.put("success", false);
            return results;
        }
        results.put("success", true);
        return results;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> registerCustomer(@Validated(value = {GroupA.class}) @RequestBody PersonInfo personInfo) {
        if (personInfo != null) {
            logger.info("register customer ,name:{},gender:{}",
                    personInfo.getPersonName(), personInfo.getGender());
        }
        Map<String, Object> modelMap = new HashMap<String, Object>();
        personInfo.setCreateTime(new Date());
        personInfo.setLastEditTime(new Date());
        long personId = 0;

        personId = iPersonService.addCustomerInfo(personInfo);

        modelMap.put("date", personId);
        if (personId >= 1) {
            logger.info("register customer success ,personId{}", personId);
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> modifyCustomerInfo(@Validated(value={GroupB.class})@RequestBody PersonInfo personInfo) {

        if (personInfo != null) {
            logger.info("modify customer info : custoemr.id:{}, custoemr.name:{}," +
                            "custoemr.pass:{},custoemr.gender:{} ", personInfo.getPersonId(),
                    personInfo.getPersonName(), personInfo.getPassWord(), personInfo.getGender());
        }

        Map<String, Object> modelMap = new HashMap<String, Object>();
        personInfo.setLastEditTime(new Date());
        int effectNum = 0;

        effectNum = iPersonService.updateCustomerInfo(personInfo);


        if (effectNum >= 1) {
            modelMap.put("success", true);

        } else {
            modelMap.put("success", false);
        }

        return modelMap;
    }

    @RequestMapping(value = "/delete/{personid}", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> dropCustomer(@PathVariable("personid") Long personId) {

        logger.info("delete customer info :customer_id:{} ", personId);
        int effectNum = -1;
        Map<String, Object> modelMap = new HashMap<String, Object>();

        effectNum = iPersonService.deleteCustomerInfo(personId);

        if (effectNum >= 1) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }

    @RequestMapping(value = "/customerinfolist", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getCustomerInfoList(@RequestBody PersonInfo personCondition, @RequestParam("rowIndex") int rowIndex,
                                                    @RequestParam("pageSize") int pageSize) {

        Map<String, Object> modelMap = new HashMap<String, Object>();
        logger.info("customerinfolist personCondition: {}, rowIndex:{}, pageSize{}"
                , personCondition, rowIndex, pageSize);

        List<PersonInfo> customerInfoList = null;
        customerInfoList = iPersonService.getCustomerInfoList(personCondition, rowIndex, pageSize);
        modelMap.put("date", customerInfoList);
        if (customerInfoList != null && customerInfoList.size() >= 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }

        return modelMap;
    }
    @RequestMapping(value = "/insertcustomerinfolist", method = RequestMethod.GET)
    @ResponseBody

    private Map<String, Object> insertCustomerInfoList(  @Validated(value = {GroupA.class})@RequestBody
                                                                   List<PersonInfo> personInfoList) {

        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",true);
        return modelMap;
    }
}
