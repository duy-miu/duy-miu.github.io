package model.helper;

import model.bean.Item;

import java.util.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Cart {
    List<Item> itemList = new ArrayList<Item>();

    public void addItem(Item item){
        boolean isExisted = false;
        for(Item i: itemList){
            if(i.getId() == item.getId()){
                //update quantity only
                i.setQuantity(i.getQuantity()+item.getQuantity());
                isExisted = true;
            }
        }
        if(!isExisted) {
            //new item
            itemList.add(item);
        }
    }

    public void removeItem(Item item){
        itemList.remove(item);
    }

    public List<Item> getItemList(){
        return itemList;
    }

    public float getCostTotal(){
        float sum = 0.0f;
        for (Item item: itemList) {
            sum +=item.getPrice() * item.getQuantity();
        }
        DecimalFormat df = new DecimalFormat("#,##");
        df.setRoundingMode(RoundingMode.CEILING);
        return Float.valueOf(df.format(sum));
    }

}
