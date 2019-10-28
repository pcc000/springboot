package com.blackfish.java.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;

/**
 * @Auther: shuyiwei
 * @Date: 2019/10/28 20:02
 * @Description:
 */
public class NewioServer {

    public static void main(String[] args) throws IOException {
        //创建一个Selector
        Selector selector = Selector.open();

        //一个线程负责选择就绪的channel
        while (true){
            //选择就绪事件 select()是可以被中断的
            int readyChannelCount = selector.select();
            if(0==readyChannelCount){
                continue;
            }
            //得到就绪的channel
            Set<SelectionKey> selectedKeys =  selector.selectedKeys();
        }
    }
}
