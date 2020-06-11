package model.bean;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Item {
    private int id;
    private String name;
    private float price;
    private int quantity;

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, float price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(int id, String name, float price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getTotal(){
        float total = 0.0f;
        total = this.getPrice() * this.getQuantity();
        DecimalFormat df = new DecimalFormat("#,##");
        df.setRoundingMode(RoundingMode.CEILING);
        return Float.valueOf(df.format(total));
    }
}
