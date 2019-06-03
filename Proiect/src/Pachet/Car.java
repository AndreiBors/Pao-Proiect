package Pachet;

import java.io.Serializable;

public class Car implements Serializable {
    protected Integer price;
    protected Integer width;
    protected Integer length;
    protected Integer height;
    protected String name;
    protected String color;
    //protected static int ID=0;
    //protected final int objectId;
    public void print()
    {
        System.out.println("Name: "+name);
        System.out.println("Price: "+price);
        System.out.println("Dimension: width: "+width+"; length: "+length+"; height: "+height+"; color: "+color);
    }

    public Car(Integer price, Integer width, Integer length, Integer height, String name,String color) {
        this.price = price;
        this.width = width;
        this.length = length;
        this.height = height;
        this.name = name;
        this.color=color;
        //objectId=ID;
        //ID++;
    }
    public Car()
    {
        //objectId=ID;
        //ID++;
    }
    public String filename(){return "Car.txt";}
    public String get_name()
    {
        return name;
    }
    public Integer get_price()
    {
        return price;
    }

}
