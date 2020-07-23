package com.blackfish.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/30 11:44
 * @Description:
 */
public class ConsumerOrder {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("myGroup");

        consumer.setNamesrvAddr("192.168.195.129:9876");

        consumer.subscribe("myfirstTopic22", "*");



        consumer.registerMessageListener(new MessageListenerOrderly() {

            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()) + " Thread:" + Thread.currentThread().getName());;
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();
        System.out.println("Consumer g02 start...");
    }
}
