package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class DrinksPage extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView orderbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_page);
        orderbtn = (TextView) findViewById(R.id.orderbtn_drinkpage);
        recyclerView  = (RecyclerView) findViewById(R.id.recycleview_drink);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openorder();
            }
        });
        DrinkData[] drinkData = new DrinkData[]{
                new DrinkData(R.drawable.aqua,"Aqua",123),
        new DrinkData(R.drawable.jusapel,"Apel",123),
        new DrinkData(R.drawable.jusmangga,"Mangga",123),
        new DrinkData(R.drawable.jusalpukat,"Alpukat",123),
        };

        DrinkAdapter drinkAdapter = new DrinkAdapter(drinkData, DrinksPage.this);
        recyclerView.setAdapter(drinkAdapter);
    }

    private void openorder() {
        Intent intent = new Intent(this,MyOrder.class);

        startActivity(intent);
    }


}