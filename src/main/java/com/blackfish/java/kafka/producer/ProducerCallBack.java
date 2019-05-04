package com.blackfish.java.kafka.producer;


import com.blackfish.java.util.common.JsonUtil;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/3 23:16
 * @Description:
 */
public class ProducerCallBack implements Callback {


    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if(null != e){
            e.printStackTrace();
        }else{
            System.out.println("callback come in");
            System.out.println(JsonUtil.toString(recordMetadata));
        }

    }
}
