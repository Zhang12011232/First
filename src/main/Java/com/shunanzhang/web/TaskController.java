package com.shunanzhang.web;

import com.shunanzhang.entity.PersonInfo;
import com.shunanzhang.service.IPersonService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="task",method = {RequestMethod.GET,RequestMethod.POST})
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private IPersonService iPersonService;

    @RequestMapping(value = "/test",method=RequestMethod.GET)
    @ResponseBody
    private Map ownerLoginCheck(HttpServletRequest request) {

          Map<String,String> result=new HashMap<String,String>();
        logger.info("test");
        logger.debug("test");
        logger.error("test");
          result.put("rest","success");
          return result;
    }
    @RequestMapping(value = "/find",method=RequestMethod.GET)
    @ResponseBody
    private Map queryCustomeerInfo(@RequestParam("personid") long personId){
        Map<String ,Object> results=new HashMap<String,Object>();
        PersonInfo  personInfo=iPersonService.getCustomerInfo(personId);
        if(personInfo==null){
            logger.info("query customer info failed ,customer :{}",personInfo);
            results.put("success",false);
            return results;
        }
        results.put("success",true);
        return results;
    }
}
