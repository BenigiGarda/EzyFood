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

public class FinalPage extends AppCompatActivity {
    Button button;
    DatabaseHelper databaseHelperfinal;
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<String> listitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        button = (Button)findViewById(R.id.mainmenubtn);
        databaseHelperfinal = new DatabaseHelper(this);
        listView = (ListView) findViewById(R.id.listview_final);
        listitem = new ArrayList<>();
        ListOrder();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmain();
            }
        });


    }

    private void ListOrder() {
        Cursor cursor = databaseHelperfinal.getdata();
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

    private void openmain() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}