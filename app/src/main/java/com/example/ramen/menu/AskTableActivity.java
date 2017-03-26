package com.example.ramen.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ramen.menu.Model.Order;
import com.example.ramen.menu.Model.StaticProperties;


public class AskTableActivity extends AppCompatActivity {

    private EditText tableNumber;
    private Button tableButton;
    private EditText ip;
    private EditText port;

    Order order;
    private NetworkTask networkTask;
    private StaticProperties staticProperties;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_table);

        tableNumber = (EditText) findViewById(R.id.tableNumberEdit);
        tableButton = (Button) findViewById(R.id.setTableButton);
        ip = (EditText) findViewById(R.id.ipText);
        port = (EditText) findViewById(R.id.portText);
        order = new Order();

        autoConnect();



        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    StaticProperties.setTableNo(Integer.parseInt(tableNumber.getText().toString())); //Throws exception if table number is left blank
                    StaticProperties.setIpAddress(ip.getText().toString().trim());
                    StaticProperties.setPortNumber((Integer) Integer.parseInt(port.getText().toString()));
                    Log.i("info", "" + ip.getText().toString().trim() + "port: " + (Integer) Integer.parseInt(port.getText().toString()));
                    try {
                        Log.i("info ", "AsyncTask running");
                        networkTask = new NetworkTask();
                        networkTask.execute();
                        StaticProperties.setNetworkTask(networkTask);
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

    private void autoConnect(){

        //TODO autoconnect
    }
}
