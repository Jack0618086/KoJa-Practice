package com.jack.mcdonalds;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Mcdonald {
    public static void main(String[] args) {
        Mcdonald mcdonald = new Mcdonald();
        mcdonald.print();
    }

    Map<String, Item> menu = new HashMap<>();
    public Mcdonald () {
        File file = new File("mcdonalds.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                String [] tokens = line.split(",");
                Item item = new Item(
                        tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3]));
                menu.put(item.id, item);
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("can't read menu");
        }
    }

    public void print () {
        for (Map.Entry<String, Item> itemEntry : menu.entrySet()){
            System.out.println(itemEntry.getValue());
        }
    }
}


class Item {
    String id;
    String name;
    int price;
    int calorie;

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + price + "\t" + calorie;
    }

    public Item(String id, String name, int price, int calorie) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.calorie = calorie;
    }
}