package com.blackfish.rocketmq;

import com.blackfish.java.util.common.JsonUtil;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/17 20:19
 * @Description:
 */
public class Producer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("myGroup");
        producer.setNamesrvAddr("192.168.195.129:9876");
        producer.start();

        Message message = new Message("myfirstTopic11","helllo world".getBytes());

        Message message1 = new Message("myfirstTopic11","helllo1 world".getBytes());
        List<Message> lists = new ArrayList<>();
        lists.add(message);
        lists.add(message1);
        //同步发送
        SendResult result = producer.send(lists);
        System.out.println(JsonUtil.toJson(result));
//        producer.shutdown();
        //异步
//        producer.send(message, new SendCallback() {
//            @Override
//            public void onSuccess(SendResult sendResult) {
//                System.out.println("successs sendResult:"+sendResult);
//            }
//
//            @Override
//            public void onException(Throwable throwable) {
//                throwable.printStackTrace();
//                System.out.println("异常");
//            }
//        });
//        producer.shutdown();

        //单向发送
        producer.sendOneway(message);

        //tag用来过滤消息  消息分组

        System.out.println("Producer end");

    }
}
