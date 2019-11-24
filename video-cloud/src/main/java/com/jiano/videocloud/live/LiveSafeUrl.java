package com.jiano.videocloud.live;


import com.google.gson.Gson;
import com.jiano.videocloud.util.LiveSignUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/live")
@Controller
public class LiveSafeUrl {

    private static Logger logger = LoggerFactory.getLogger("LiveSafeUrl");

    // 推流域名
    private String pushDomainUrl = "****************";
    // 播放域名
    private String pullDomainUrl = "*****************";

    // 推流streamName 必须与播放streamName一致，观众才能播放观看
    private String streamName = "jiano_h265";
    // 推流鉴权主备key
    private String pushStreamZhuKey = "*************";
    private String pushStreambeiKey = "**************";

    // 拉流鉴权主备Key
    private String pullStreamZhuKey = "****************";
    private String pullStreamBeiKey = "**************";


    //txTime 为推拉流地址的有效时间
    private Long txTime = 0L;

    // 鉴权有效时间为3600秒
    private Long activeTime = 3600L;

    // 获取当前时间戳
    private Long getTimeStamp(){
        return System.currentTimeMillis();
    }

    @ResponseBody
    @GetMapping("/getPushUrl")
    public Map<String,String> getPushUrl(){
        Map<String,String> map = new HashMap<>();
        txTime = getTimeStamp();
        String pushUrl = pushDomainUrl + streamName + "?" + LiveSignUtils.getSafeUrl(pushStreamZhuKey,streamName,txTime);
        String pullUrlRtmp = pullDomainUrl + streamName + "?" + LiveSignUtils.getSafeUrl(pullStreamZhuKey,streamName,txTime);
        String pullUrlFlv = pullDomainUrl + streamName + ".flv?" + LiveSignUtils.getSafeUrl(pullStreamZhuKey,streamName,txTime);
        String pullUrlHls = pullDomainUrl + streamName + ".m3u8?" + LiveSignUtils.getSafeUrl(pullStreamZhuKey,streamName,txTime);
        map.put("pushUrl",pushUrl);
        map.put("pullUrlRtmp",pullUrlRtmp);
        map.put("pullUrlFlv",pullUrlFlv);
        map.put("pullUrlHls",pullUrlHls);

        logger.info("txTime=" + txTime);
        logger.info("pushUrl=" + pushUrl);
        logger.info("pullUrlRtmp=" + pullUrlRtmp);
        logger.info("pullUrlFlv=" + pullUrlFlv);
        logger.info("pullUrlHls=" + pullUrlHls);
        return map;
    }



}
