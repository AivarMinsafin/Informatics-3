package ru.kpfu.itis.minsafin.aivar.task2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServer {
    private static int PORT = 11903;

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(PORT);
        serverSocketChannel.bind(inetSocketAddress);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        SocketChannel channel;
        boolean stop = false;
        while (selector.isOpen()) {
            int num = selector.select();
            if (num == 0) continue;
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    channel = serverSocketChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    System.out.println("Connected");
                } else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int read = socketChannel.read(byteBuffer);
                    if (read != -1) {
                        while (read != -1) {
                            byteBuffer.flip();
                            while (byteBuffer.hasRemaining()) {
                                byteArrayOutputStream.write(byteBuffer.get());
                            }
                            byteBuffer.clear();
                            read = socketChannel.read(byteBuffer);
                        }
                        Student student = Student.deserialize(byteArrayOutputStream.toByteArray());
                        System.out.println(student.toString());
                        stop = true;
                    } else {
                        System.out.println("No data");
                        stop = true;
                    }
                }
                iterator.remove();
                if (stop){
                    selector.close();
                }
            }
        }
    }
}
