package com.blackfish.rocketmq;

import com.blackfish.java.util.common.JsonUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/6/20 23:15
 * @Description:
 */
public class Consumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("myGroup");

        consumer.setNamesrvAddr("192.168.195.129:9876");

        consumer.subscribe("myfirstTopic22","*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for(MessageExt es : list){
                    System.out.println("====================");
//                    System.out.println(JsonUtil.toJson(es));
                    System.out.println(new String(es.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //集群 和 广播模式
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.start();

        System.out.println("end");
    }
}
