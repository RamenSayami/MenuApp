package com.example.ramen.menu.Model;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ramen.menu.NetworkTask;
import com.example.ramen.menu.SocketClient;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by ramen on 3/3/17.
 */

public class SocketProperties {
    private static String ipAddress;
    private static int portNumber;
    private static Thread clientThread;
    private static SocketClient client;
    private static NetworkTask networkTask;


    public static Thread getClientThread() {
        return clientThread;
    }

    public static void setClientThread(Thread clientThread) {
        SocketProperties.clientThread = clientThread;
    }


    public static SocketClient getClient() {
        return client;
    }

    public static void setClient(SocketClient client) {
        SocketProperties.client = client;
    }

    public SocketProperties() {
    }

    public static String getIpAddress() {
        return ipAddress;
    }

    public static void setIpAddress(String ipAddress) {
        SocketProperties.ipAddress = ipAddress;
    }

    public static int getPortNumber() {
        return portNumber;
    }

    public static void setPortNumber(int portNumber) {
        SocketProperties.portNumber = portNumber;
    }

    public static void setNetworkTask(NetworkTask networkTask1){
        networkTask = networkTask1;
    }

    public static NetworkTask getNetworkTask(){
        return networkTask;
    }

    public static void sendOrder(Order order){
        networkTask.SendDataToNetwork(order);
    }


}
