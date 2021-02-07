package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView button1,orderbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (TextView) findViewById(R.id.Button1);
        orderbtn = (TextView) findViewById(R.id.orderbtn_main);
        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openorder();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrink();
            }
        });
    }

    private void openorder() {
        Intent intent = new Intent(this,MyOrder.class);
        startActivity(intent);
    }

    public void openDrink() {
        Intent intent = new Intent(this,DrinksPage.class);
        startActivity(intent);
    }
}