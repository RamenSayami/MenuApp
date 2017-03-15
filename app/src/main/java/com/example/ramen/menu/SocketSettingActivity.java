package com.example.ramen.menu;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ramen.menu.Model.SocketProperties;

public class SocketSettingActivity extends AppCompatActivity {

    EditText ipAddressText;
    EditText portText;
    Button okButton;
    Button cancleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_setting);

        ipAddressText = (EditText) findViewById(R.id.ipText);
        portText = (EditText) findViewById(R.id.portText);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SocketProperties.setIpAddress(ipAddressText.getText().toString());
                SocketProperties.setPortNumber(Integer.parseInt(portText.getText().toString()));
                Toast.makeText(getApplicationContext(),"Socket Settings Changed",Toast.LENGTH_SHORT);
            }
        });


        cancleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(1);
            }
        });
    }
}
