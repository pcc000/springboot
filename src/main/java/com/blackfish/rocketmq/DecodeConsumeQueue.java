package com.blackfish.rocketmq;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther: shuyiwei
 * @Date: 2020/7/24 17:46
 * @Description:
 */
public class DecodeConsumeQueue {

    public static void main(String[] args) throws IOException {
        decodeCQ(new File("D:\\test\\commitLog\\00000000000000000000"));
    }

    static void decodeCQ(File consumeQueue) throws IOException {
        FileInputStream fis = new FileInputStream(consumeQueue);
        DataInputStream dis = new DataInputStream(fis);

        long preTag = 0;
        long count = 1;
        while (true) {
            long offset = dis.readLong();
            int size = dis.readInt();
            long tag = dis.readLong();

            if (size == 0) {
                break;
            }
            preTag = tag;
            System.out.printf(" %d %d %d\n",   tag, size, offset);
        }
        fis.close();
    }
}
