package com.example.ezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {



    DrinkData[] drinkData;
    Context context;

    public DrinkAdapter(DrinkData[] drinkData, DrinksPage drinksPage) {
        this.drinkData = drinkData;
        this.context = drinksPage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.drinks_menu, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DrinkData drinkDatalist = drinkData[position];
        holder.imageView.setImageResource(drinkDatalist.getDrinkimage());
        holder.textView1.setText(drinkDatalist.getDrinkname());
        holder.textView2.setText("Rp." + drinkDatalist.getDrinkprice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Detail.class);
                intent.putExtra("image", drinkDatalist.getDrinkimage());
                intent.putExtra("name", drinkDatalist.getDrinkname());
                intent.putExtra("price",drinkDatalist.getDrinkprice());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return drinkData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1, textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagedrink);
            textView1 = itemView.findViewById(R.id.drink_name);
            textView2 = itemView.findViewById(R.id.drink_price_menu);
        }
    }
}
