package com.example.ramen.menu;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ramen.menu.Model.Order;
import com.example.ramen.menu.Model.SocketProperties;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class NetworkTask extends AsyncTask<Void, Order, Void> {
        Socket nSocket;
        ObjectInputStream nis;
        ObjectOutputStream nos;

        @Override
        protected void onPreExecute() {
            Log.i("AsyncTask", "onPreExecute");
            try {
                SocketAddress sockaddr = new InetSocketAddress(SocketProperties.getIpAddress(), SocketProperties.getPortNumber());
                nSocket = new Socket();
                nSocket.connect(sockaddr, 5000);
                if (nSocket.isConnected()) {
                    Log.i("Socket info", "Client Connected");

                    nis = (ObjectInputStream) nSocket.getInputStream();
                    nos = (ObjectOutputStream) nSocket.getOutputStream();
                }
                else {
                    Log.i("Socket info", "Client not Connected");
                }
            } catch (Exception e) {

                e.printStackTrace();
            }
        }


        @Override
        protected Void doInBackground(Void... params) {
//            boolean connection = false;

//            try {
//                if(nis.available()>0){
//
//                        Order msg = (Order) nis.readObject();
//                        publishProgress(msg);
//                        Log.i("Object Recieved",msg.toString());
//
//                }
//            } catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//
//            return null;

            while(true){
                try {
                    if(nSocket.isConnected()&&nis.available()<0){
                        continue;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Order msg = (Order) nis.readObject();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onProgressUpdate(Order... values) {
            super.onProgressUpdate(values);
        }

        public void SendDataToNetwork(Order order) { //You run this from the main thread.
            try {
                if (nSocket.isConnected()) {
                    nos.writeObject(order);
                    nos.flush();
                    Log.i("AsyncTask", "SendDataToNetwork: Writing received message to socket");
                } else {
                    Log.i("AsyncTask", "SendDataToNetwork: Cannot send message. Socket is closed");
                }
            } catch (Exception e) {
                Log.i("AsyncTask", "SendDataToNetwork: Message send failed. Caught an exception");
            }
        }
    }