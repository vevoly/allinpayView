package com.aixin999.controller;

import com.aixin999.util.AllinpayUtil;
import com.aixin999.util.DateTools;
import com.aixin999.util.HttpClientUtil;
import com.aixin999.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 通联支付接口调用Controller
 */
@Controller
@RequestMapping("/allinpay/")
public class AllinpayCtrl {

    /*String propFile = "cfg.properties";
    String appKey = PropertyUtil.getValueByKey(propFile, "app_key");
    String secretKey = PropertyUtil.getValueByKey(propFile, "secret_key");
    String v = PropertyUtil.getValueByKey(propFile, "v");
    String signV = PropertyUtil.getValueByKey(propFile, "sign_v");
    String format = PropertyUtil.getValueByKey(propFile, "format");
    String httpUrl = PropertyUtil.getValueByKey(propFile, "http_url");*/

    /**
     * app key
     */
    @Value("#{cfg.app_key}")
    String appKey;

    /**
     * app secret
     */
    @Value("#{cfg.app_secret}")
    String appSecret;

    /**
     * 数据密钥，用户密码加密
     */
    @Value("#{cfg.secret_key}")
    String secretKey;

    /**
     * api版本号
     */
    @Value("#{cfg.v}")
    String v;

    /**
     * 签名版本号
     */
    @Value("#{cfg.sign_v}")
    String signV;

    /**
     * 返回数据格式
     */
    @Value("#{cfg.format}")
    String format;

    /**
     * 调用接口地址
     */
    @Value("#{cfg.http_url}")
    String httpUrl;

    /**
     * 获取卡信息
     * @param cardId 卡号
     * @param password 密码
     * @return 卡信息
     */
    @RequestMapping(value = "getCardInfo", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getCardInfo(String cardId, String password) {

        //调用接口方法名
        String method = PropertyUtil.getValueByKey("cfg.properties", "method.get_card_info");
        //当前时间戳
        String timestamp = DateTools.dateToNum14(new Date());
        String ret = null;
        //调用接口参数
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("timestamp", timestamp);
        params.put("method", method);
        params.put("format", format);
        params.put("v", v);
        params.put("app_key", appKey);
        params.put("card_id", cardId);
        //获取加密后的密码
        params.put("password", AllinpayUtil.passwordCrypto(password, secretKey));
        params.put("sign_v", signV);

        try {
            //组装参数
            String paramString = AllinpayUtil.buildParams(params, appSecret);
            //调用接口并获取返回数据
            ret = HttpClientUtil.sendGet(httpUrl, paramString);
            //System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @RequestMapping(value = "getCardLog", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getCardLog(String cardId, String password, String beginDate, String endDate, String pageNo, String pageSize) {
        //如果没有起始日期beginDate的话，起始日期beginDate为当前日期-90；结束日期endDate为当前日期
        beginDate = beginDate == null || "".equals(beginDate) ? DateTools.dateToNum8(DateTools.getBeforeSomeOneDay(90)) : beginDate;
        endDate = endDate == null || "".equals(endDate) ? DateTools.dateToNum8(new Date()) : endDate;
        //如果没有页码pageNo的话，页码为1
        pageNo = pageNo == null || "".equals(pageNo) || "0".equals(pageNo) ? "1" : pageNo;
        //如果没有pageSize的话，pageSize为30
        pageSize = pageSize == null || "".equals(pageSize) ? "30" : pageSize;

        String method = PropertyUtil.getValueByKey("cfg.properties", "method.get_card_log");
        String timestamp = DateTools.dateToNum14(new Date());
        String ret = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("timestamp", timestamp);
        params.put("method", method);
        params.put("format", format);
        params.put("v", v);
        params.put("app_key", appKey);
        params.put("card_id", cardId);
        params.put("password", AllinpayUtil.passwordCrypto(password, secretKey));
        params.put("sign_v", signV);

        params.put("page_no", pageNo);
        params.put("page_size", pageSize);
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);

        try {
            String paramString = AllinpayUtil.buildParams(params, appSecret);
            ret = HttpClientUtil.sendPost(httpUrl, paramString);
            //System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

}
