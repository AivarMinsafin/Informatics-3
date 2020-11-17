package ru.itis.aivar.task2;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static int PORT = 80;
    public static String HOST = "study.istamendil.info";
    public static String resultFile = "result.html";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName(HOST), PORT);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        PrintWriter pw = new PrintWriter(out);
//        StringBuilder query = new StringBuilder();
//        query
//                .append("GET ").append("/").append(" HTTP/1.1").append("\n")
//                .append("Host: ").append(HOST);
        pw.print("GET / HTTP/1.1\r\n");
        pw.print("Host: "+HOST+"\r\n\r\n");
        pw.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String t;
        while ((t = br.readLine()) != null) System.out.println(t);
        br.close();
    }
}
