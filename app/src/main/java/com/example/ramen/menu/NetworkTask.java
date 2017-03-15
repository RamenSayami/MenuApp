package com.example.ramen.menu;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ramen.menu.Model.Order;
import com.example.ramen.menu.Model.StaticProperties;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class NetworkTask extends AsyncTask<Void, Order, Void> {
        Socket nSocket;
        ObjectInputStream nis;
        ObjectOutputStream nos;

        public NetworkTask(){

        }

        @Override
        protected Void doInBackground(Void... params) {
            Log.i("AsyncTask", "Setup Connection");
            try {
                Log.i("Socket",""+StaticProperties.getIpAddress());
                SocketAddress sockaddr = new InetSocketAddress(StaticProperties.getIpAddress(), StaticProperties.getPortNumber());
                nSocket = new Socket();
                nSocket.connect(sockaddr, 5000);
                Log.i("info ", "AsyncTask running socket connection");

                if (nSocket.isConnected()) {
                    Log.i("Socket info", "Client Connected");

                    nis =new ObjectInputStream(nSocket.getInputStream());
                    nos = new ObjectOutputStream(nSocket.getOutputStream());
                    nos.flush();
                }
                else {
                    Log.i("Socket info", "Client not Connected");
                }
            } catch (Exception e) {

                e.printStackTrace();
            }

            Log.i("info ", "Background running");

            while(true){
                try {
                    Order msg = (Order) nis.readObject();

                } catch (Exception e) {
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
                e.printStackTrace();
            }
        }
    }