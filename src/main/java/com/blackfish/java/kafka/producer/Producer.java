package com.blackfish.java.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/1 09:55
 * @Description:
 */
public class Producer {


    private static Properties kafkaPro = new Properties();

    static{
        kafkaPro.put("bootstrap.servers","localhost:9092");
        kafkaPro.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaPro.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
    }

    public KafkaProducer<String,String> producer(){
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(kafkaPro);
        return producer;
    }

    public static void main(String[] args) {
        ProducerRecord<String,String> record = new ProducerRecord<String,String>("wj","7878","222");
        Producer producer = new Producer();
        KafkaProducer<String,String> kafkaProducer = producer.producer();
//        Future<RecordMetadata> recordMetadata =  kafkaProducer.send(record);
//        try{
//            System.out.println(recordMetadata.get());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        kafkaProducer.send(record,new ProducerCallBack());
    }
}
