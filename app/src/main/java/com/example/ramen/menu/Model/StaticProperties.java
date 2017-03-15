package com.example.ramen.menu.Model;

import com.example.ramen.menu.NetworkTask;

/**
 * Created by ramen on 3/15/17.
 * This class holds data that do not change througout the app because the connection is made only once and the info needs to be saved and also for tbale number which does not change, well for now.. hehe
 */


public class StaticProperties {

    private static String ipAddress;
    private static int portNumber;
    private static NetworkTask networkTask;
    private static int tableNo;

    public StaticProperties() {
    }

    public static int getTableNo() {
        return tableNo;
    }

    public static void setTableNo(int table) {
        tableNo = table;
    }

    public static String getIpAddress() {
        return ipAddress;
    }

    public static void setIpAddress(String ip) {
        ipAddress = ip;
    }

    public static int getPortNumber() {
        return portNumber;
    }

    public static void setPortNumber(int port) {
        portNumber = port;
    }

    public static void setNetworkTask(NetworkTask networkTask1) {
        networkTask = networkTask1;
    }

    public static NetworkTask getNetworkTask() {
        return networkTask;
    }

}

