package com.gyf.io;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketBIO {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("---------get serverSocket");
        while (true) {
            Socket accept = serverSocket.accept(); // 阻塞
            System.out.println("-----accept socket");
            new Thread(() -> {
                try {
                    InputStream inputStream = accept.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        String readLine = bufferedReader.readLine();// 阻塞
                        System.out.println("readLine = "+readLine);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            });
        }
    }
}
