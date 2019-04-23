package com.blackfish.java.util.client;

import com.blackfish.java.util.common.JsonUtil;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/23 14:43
 * @Description:
 */
public class Test {

    private String partnerId;

    private String verifyKey;

    private Map<String,String> extParam;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getVerifyKey() {
        return verifyKey;
    }

    public void setVerifyKey(String verifyKey) {
        this.verifyKey = verifyKey;
    }

    public Map<String, String> getExtParam() {
        return extParam;
    }

    public void setExtParam(Map<String, String> extParam) {
        this.extParam = extParam;
    }

    public static void main(String[] args) {
        Map<String, String> param = new HashMap<String,String>();
        param.put("Content-Type","application/json");
        param.put("charset","UTF-8");
        Test test = new Test();
        Map<String,String> extraParam = new HashMap<>();
        extraParam.put("name","小明");
        extraParam.put("certNo","");
        extraParam.put("mobile","18252059044");
        test.setExtParam(extraParam);
        System.out.println(JsonUtil.toString(test));
        StringEntity se = new StringEntity(JsonUtil.toString(test), "utf-8");
        ClientResultDTO clientResultDTO = HttpClientUtil.requestPost("https://apist.baiqishi.com/ids/qly/search", se,param);
        System.out.println(JsonUtil.toString(clientResultDTO));

    }
}
