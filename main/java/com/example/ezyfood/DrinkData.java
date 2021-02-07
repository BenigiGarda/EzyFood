package com.example.ezyfood;

import android.content.Intent;

public class DrinkData {
    private Integer drinkimage;
    private String drinkname;
    private Integer drinkprice;

    public DrinkData(Integer drinkimage, String drinkname, Integer drinkprice) {
        this.drinkimage = drinkimage;
        this.drinkname = drinkname;
        this.drinkprice = drinkprice;
    }

    public Integer getDrinkimage() {
        return drinkimage;
    }

    public void setDrinkimage(Integer drinkimage) {
        this.drinkimage = drinkimage;
    }

    public String getDrinkname() {
        return drinkname;
    }

    public void setDrinkname(String drinkname) {
        this.drinkname = drinkname;
    }

    public Integer getDrinkprice() {
        return drinkprice;
    }

    public void setDrinkprice(Integer drinkprice) {
        this.drinkprice = drinkprice;
    }

}


