package com.blackfish.java.nio;

import org.jboss.netty.channel.ServerChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
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

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9200));
        //注册到Selector、让selector帮忙检测连接进来
        //1、要用非阻塞方式
        serverSocketChannel.configureBlocking(false);
        //2、注册
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        //一个线程负责选择就绪的channel
        while (true){
            //选择就绪事件 select()是可以被中断的
            int readyChannelCount = selector.select();
            if(0==readyChannelCount){
                continue;
            }
            //得到就绪的channel
            Set<SelectionKey> selectedKeys =  selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                if(selectionKey.isAcceptable()){
                    //连接进来了
                    //接受连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //注册到selector 让他帮忙检测数据到来
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    //数据已发过来、可以读取处理了
                    //多线程处理
                    //取消selector注册，防止线程池处理不及时，重复选择
                    selectionKey.cancel();
                }else if(selectionKey.isWritable()){
                    //可以发送数据了
                }else if(selectionKey.isConnectable()){
                    //客户端用，联通了服务器
                }
                //处理了，一定要从selectionKey集中移除
                iterator.remove();
            }
        }
    }

    static class SocketProcess implements Runnable{

        SelectionKey key;

        @Override
        public void run() {

        }
    }
}
