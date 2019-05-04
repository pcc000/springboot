package com.blackfish.java.kafka.consumer;

import com.blackfish.java.util.common.JsonUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/4 16:13
 * @Description:
 */
public class Consumer {

    private static Properties kafkaPro = new Properties();

    static{
        kafkaPro.put("bootstrap.servers","localhost:9092");
        kafkaPro.put("group.id","pcc");
        kafkaPro.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        kafkaPro.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
    }

    public KafkaConsumer<String,String> createConsumer(){
        return new KafkaConsumer<String, String>(kafkaPro);
    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        KafkaConsumer<String,String> con = consumer.createConsumer();
        con.subscribe(Collections.singletonList("wj"));
        try{
            while(true){
                ConsumerRecords<String,String> records = con.poll(100);
                for(ConsumerRecord record : records){
                    System.out.println("result:"+JsonUtil.toString(record));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.close();
        }
    }
}
