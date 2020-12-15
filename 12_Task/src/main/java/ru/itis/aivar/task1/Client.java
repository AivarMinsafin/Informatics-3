package ru.itis.aivar.task1;

import java.awt.*;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Throwable {
        System.out.println("Starting client...");
        Socket s = new Socket(InetAddress.getLocalHost(), Protocol.PORT);
        OutputStream out = s.getOutputStream();
        System.out.println("Starting sending random colors");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Thread.sleep(1000);
            System.out.println("Enter color in RGB format (255, 255, 255):");
            String rgbStr = scanner.nextLine();
            String[] rgbStrs = rgbStr.replace(" ", "").split(",");
            int[] rgb = new int[3];
            for (int i = 0; i < rgb.length; i++) {
                rgb[i] = Integer.parseInt(rgbStrs[i]);
            }
//            int r = (new Random()).nextInt(255);
//            int g = (new Random()).nextInt(255);
//            int b = (new Random()).nextInt(255);
            Color c = new Color(rgb[0], rgb[1], rgb[2]);
            ByteBuffer buf = ByteBuffer.allocate(12);
            buf.putInt(rgb[0]).putInt(rgb[1]).putInt(rgb[2]);
            System.out.println(">> " + c);
            System.out.println(Arrays.toString(buf.array()));
            out.write(buf.array());
            out.flush();
        }
    }
}
