package ru.kpfu.itis.minsafin.aivar;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
// создаем буфер размера 48 байтов (!)
        ByteBuffer buf = ByteBuffer.allocate(48);
// читаем из канала в буфер, возвращается реальное количество считанных байтов
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            // режим чтения полученных данных из буфера
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print(buf.get());
            }
            // режим записи новых данных в буфер
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
