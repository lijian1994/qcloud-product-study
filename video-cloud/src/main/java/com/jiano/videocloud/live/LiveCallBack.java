package com.jiano.videocloud.live;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/live")
@Controller
public class LiveCallBack {
    private static Logger logger = LoggerFactory.getLogger("LiveCallBack");

    @ResponseBody
    @RequestMapping("/streamNotify")
    public Map<String,Object> streamBeginNotifyUrl(@RequestBody String json){
        logger.info("有回调进来了");
        logger.info("json = " + json);

//        Map<String,String[]> streamInfo = request.getParameterMap();
//        for (String key:streamInfo.keySet()) {
//            for (String str:streamInfo.get(key)){
//                logger.info("key=" + key + ",value="  + str);
//            }
//            logger.info("***********************");
//        }
//        logger.info("request.getServerName()：" + request.getServerName());
//        logger.info("request.getParameter(空字符串)" + request.getParameter(""));
//        logger.info("request.getParameter(app)" + request.getParameter("app"));
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        return map;
    }
}
