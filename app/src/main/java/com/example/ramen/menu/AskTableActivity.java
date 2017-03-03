package com.example.ramen.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ramen.menu.Model.Order;

public class AskTableActivity extends AppCompatActivity {

    private EditText tableNumber;
    private Button tableButton;
    Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_table);

        tableNumber = (EditText) findViewById(R.id.tableNumberEdit);
        tableButton = (Button) findViewById(R.id.setTableButton);
        order = new Order();

        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 1: Check if the table number is valid (because in a resturant only finite tables)
                try{
                    order.setTableNo(Integer.parseInt(tableNumber.getText().toString()));

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Invalid number Sorry, Try Again!",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
