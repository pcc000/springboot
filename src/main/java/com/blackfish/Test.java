package com.blackfish;

import com.blackfish.java.util.client.ClientResultDTO;
import com.blackfish.java.util.client.HttpClientUtil;
import com.blackfish.java.util.common.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: shuyiwei
 * @Date: 2020/7/24 14:19
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException {
        for(int i=0;i<1000000;i++){
            Map<String,Object> params = new HashMap<>();
            String defalut ="093508";
            String id = defalut.substring(0, defalut.length() - String.valueOf(i).length()) + String.valueOf(i);
            params.put("id","3406"+id);
            System.out.println(JsonUtil.toJson(params));
            List<NameValuePair> pairList = new ArrayList<>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                pairList.add(pair);
            }
            HttpEntity httpEntity = new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8"));
            ClientResultDTO resultDTO =  HttpClientUtil.requestGet("http://site.tledu.cn/sports/search.html",httpEntity);
            Document doc = Jsoup.parseBodyFragment(resultDTO.getResult());
            Element bodyElement = doc.body();
            Elements resultElement = bodyElement.getElementsByClass("result");
//        System.out.println(resultElement.toString());
            System.out.println("============================================");
            System.out.println(resultElement.html());
            if(!"没有找到!".equals(resultElement.html())){
                System.out.println("=========================================================================================================");
                System.out.println(bodyElement);
                System.out.println("=========================================================================================================");
                break;
            }
        }

//        System.out.println(JsonUtil.toJson(resultDTO.getResult()));
//        resultDTO.getResult().startsWith("<div class=\"result\">");

    }
}
