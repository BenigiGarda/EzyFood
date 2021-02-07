package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends AppCompatActivity {
    ImageView imageView;
    TextView textView1,textView2,orderbtn;
    Button order;
    EditText editText;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        databaseHelper = new DatabaseHelper(this);
        imageView = (ImageView) findViewById(R.id.drink_image_detail);
        textView1 = (TextView) findViewById(R.id.drink_title_detail);
        textView2 = (TextView) findViewById(R.id.drink_price_detail);
        editText = (EditText) findViewById(R.id.jml_order);
        orderbtn = (TextView) findViewById(R.id.orderbtn_detail);

        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openorder();
            }
        });
        Bundle bundle = getIntent().getExtras();
        final Integer image = bundle.getInt("image");
        final String name = bundle.getString("name");
        Integer price = bundle.getInt("price");

        imageView.setImageResource(image);
        textView1.setText(name);
        textView2.setText("Rp." + price);

        String temp=editText.getText().toString();
        int b=0;
        if (!"".equals(temp)){
            b=Integer.parseInt(temp);
        }

        order = (Button) findViewById(R.id.Order_More);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt = textView1.getText().toString();
                String priceTxt = textView2.getText().toString();
                String quantityTxt = editText.getText().toString();

                Boolean checkdata = databaseHelper.insertdata(nameTxt,priceTxt,quantityTxt);
                if(checkdata == true){
                    Toast.makeText(Detail.this,"Data Stored",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Detail.this,DrinksPage.class);
                    startActivity(intent);
                }else {
                    Boolean updatedata = databaseHelper.updatedata(nameTxt,priceTxt,quantityTxt);
                    if(updatedata == true){
                        Toast.makeText(Detail.this,"Data updated",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }

    private void openorder() {
        Intent intent = new Intent(this,MyOrder.class);
        startActivity(intent);
    }


}