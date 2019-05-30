package com.blackfish.java.redis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/30 11:26
 * @Description:
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6379);
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        in.read(bytes);

        String str = new String(bytes);
        System.out.println(str);


//        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
//        String line = null;
//        while((line = br.readLine())!=null){
//            System.out.println(line);
//        }
    }
}
