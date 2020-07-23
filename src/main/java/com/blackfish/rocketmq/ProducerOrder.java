package com.blackfish.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/30 11:45
 * @Description:
 */
public class ProducerOrder {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("myGroup");

        producer.setNamesrvAddr("192.168.195.129:9876");
        producer.start();

        for (int i = 1; i <= 100; i++) {


            Message message = new Message("myfirstTopic22", "TAG-B","KEY-xx",("xxooxx:" + i ).getBytes());


            message.putUserProperty("age", String.valueOf(i));
            producer.send(message);
            System.out.println("xxooxx:"+i);
        }
        producer.shutdown();
        System.out.println("produce end");
    }
}
