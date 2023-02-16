package com.study.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Auther: pcc
 * @Date: 2023/2/16 13:16
 * @Description:
 */
public class TimerServer {

    public void bind(int port) throws InterruptedException {
        EventLoopGroup eventLoopGroupBoss = new NioEventLoopGroup();
        EventLoopGroup wokerLoopGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(eventLoopGroupBoss,wokerLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChannelInitializer<SocketChannel>(){
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new TimerServerHandler());
                        }
                    });
            ChannelFuture f = bootstrap.bind(port).sync();
            f.channel().closeFuture().sync();

        }finally {
            wokerLoopGroup.shutdownGracefully();
            eventLoopGroupBoss.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new TimerServer().bind(35321);
    }

}
