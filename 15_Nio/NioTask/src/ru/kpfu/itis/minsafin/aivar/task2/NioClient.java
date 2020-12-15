package ru.kpfu.itis.minsafin.aivar.task2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioClient {
    private static int PORT = 11903;
    private static String localhost = "127.0.0.1";
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(localhost ,PORT));
        Student student = new Student(
                "Aivar",
                "Minsafin",
                19,
                new Group(
                        "11-903",
                        30
                )
        );

        byte[] bytes = Student.serialize(student);

        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }

}
