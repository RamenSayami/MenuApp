package com.example.ramen.menu;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ramen.menu.Model.Order;
import com.example.ramen.menu.Model.SocketProperties;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class AskTableActivity extends AppCompatActivity {

    private EditText tableNumber;
    private Button tableButton;
    private EditText ip;
    private EditText port;
    Order order;

    public Thread clientThread;
    public SocketClient client;
    private NetworkTask networkTask;

    //    static ServerSocket serverr;
//    public ObjectInputStream ois = null;
//    public ObjectOutputStream oos = null;
    SocketProperties socketProperties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_table);

        tableNumber = (EditText) findViewById(R.id.tableNumberEdit);
        tableButton = (Button) findViewById(R.id.setTableButton);
        ip = (EditText) findViewById(R.id.ipText);
        port = (EditText) findViewById(R.id.portText);
        order = new Order();

//        int ACCESS_TO_INTERNET=-1;
//        int NetworkState = -1;


        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    order.setTableNo(Integer.parseInt(tableNumber.getText().toString())); //Throws exception if table number is left blank
                    SocketProperties.setIpAddress(ip.getText().toString().trim());
                    SocketProperties.setPortNumber((Integer) Integer.parseInt(port.getText().toString()));
                    Log.i("info", "" + ip.getText().toString().trim() + "port: " + (Integer) Integer.parseInt(port.getText().toString()));
                    try {
//                            client = new SocketClient();
//                            SocketProperties.setClient(client);
//                            clientThread = new Thread(client);
//                            SocketProperties.setClientThread(clientThread);
//                            Log.i("info","Server Accepted");
//                            clientThread.start();
                        Log.i("info ", "AsyncTask running");

                        networkTask = new NetworkTask();
                        networkTask.execute();
                        SocketProperties.setNetworkTask(networkTask);
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);


                    } catch (Exception ex) {
                        Toast.makeText(getApplicationContext(), " Server not found", Toast.LENGTH_SHORT).show();
                        Log.i("info", "Server Not accepted");
                        ex.printStackTrace();
                    }


                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Invalid number Sorry, Try Again!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}
