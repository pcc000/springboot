package com.blackfish.rocketmq;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: shuyiwei
 * @Date: 2020/7/21 20:43
 * @Description:
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
//        RandomAccessFile raf = new RandomAccessFile("D://test/snt_mc.1.txt", "rw");
//        FileChannel fileChannel = raf.getChannel();
//
//        String a = "我要写入文件111";
//        MappedByteBuffer mbb = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, a.getBytes().length+1);
//        mbb.put(a.getBytes());
//
//        mbb.flip();
//
//        byte[] bb = new byte[mbb.capacity()];
//        while (mbb.hasRemaining()){
//            byte b = mbb.get();
//            bb[mbb.position()]=b;
//        }
//        System.out.println(new String(bb));
//        raf.close();

        long start = System.currentTimeMillis();
        File file = new File("D://test/snt_toc.2020-07-22.log");
        long len = file.length();
        final int BUFFER_SIZE = 1*1024;// 3M的缓冲
        byte[] ds = null;


        try {
            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file, "r")
                    .getChannel()
                    .map(FileChannel.MapMode.READ_ONLY, 0, len);
            for (int offset = 0; offset < len; offset += BUFFER_SIZE) {

                if (len - offset >= BUFFER_SIZE) {
                    ds = new byte[BUFFER_SIZE];
                    for (int i = 0; i < BUFFER_SIZE; i++)
                        ds[i] = mappedByteBuffer.get(offset + i);
                } else {
                    ds = new byte[(int)len - offset];
                    for (int i = 0; i < len - offset; i++) {
                        ds[i] = mappedByteBuffer.get(offset + i);
                    }
//                    for(long j=len-offset;j<offset;j++){
//                        ds[(int)j] = 0;
//                    }
                }
                // 将得到的3M内容给Scanner，这里的XXX是指Scanner解析的分隔符
//                Scanner scan = new Scanner(new ByteArrayInputStream(ds))
//                        .useDelimiter(" ");
//                while (scan.hasNext()) {
//                    // 这里为对读取文本解析的方法
//                    System.out.print(scan.next() + " ");
//                }
//                scan.close();
            }
        } catch (IOException e) {}



//        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream),BUFFER_SIZE);
//        String line = null;
//        while((line = bufferedReader.readLine())!=null){
////            System.out.println(line);
//        }
        System.out.println("exect time:"+(System.currentTimeMillis()-start)+"ms");
    }
}
