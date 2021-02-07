package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyOrder extends AppCompatActivity {

    ListView listView;
    DatabaseHelper databaseHelper;
    ArrayList<String> listitem;
    ArrayAdapter adapter;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        listView = (ListView) findViewById(R.id.listview_myorder);


        databaseHelper = new DatabaseHelper(this);
        listitem = new ArrayList<>();

        ListOrder();
        button = (Button) findViewById(R.id.paynowbtn_myorder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfinal();
            }
        });
    }

    private void openfinal() {
        Intent intent = new Intent(this,FinalPage.class);
        startActivity(intent);
    }

    private void ListOrder() {
        Cursor cursor = databaseHelper.getdata();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No Data",Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                listitem.add(cursor.getString(0));
            }
            adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listitem);
            listView.setAdapter(adapter);
        }
    }
}