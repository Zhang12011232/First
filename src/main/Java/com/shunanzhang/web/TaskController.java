package com.shunanzhang.web;

import com.shunanzhang.entity.PersonInfo;
import com.shunanzhang.service.IPersonService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "task", method = {RequestMethod.GET, RequestMethod.POST})
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private IPersonService iPersonService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    private Map ownerLoginCheck(@RequestBody PersonInfo personInfo) {

        Map<String, String> result = new HashMap<String, String>();
        logger.info("test");
        logger.debug("test");
        logger.error("test");

        System.out.println(personInfo.getPersonName());
        System.out.println(personInfo.getPassWord());
        result.put("rest", "success");

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
    private Map<String, Object> registerCustomer(@RequestBody PersonInfo personInfo) {
        if (personInfo!=null) {
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
    private Map<String, Object> modifyCustomerInfo(@RequestBody PersonInfo personInfo) {

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
}
