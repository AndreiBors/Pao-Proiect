package Pachet;

public class Hatchback extends Car {
    private Integer doors;
    public void print()
    {
        super.print();
        System.out.println("doors: "+doors);
        System.out.println("--------------------------------------------");
    }

    public Hatchback(Integer price, Integer width, Integer length, Integer height, String name,String color, Integer doors) {
        super(price, width, length, height, name,color);
        this.doors = doors;
    }
    public Hatchback() {}
}
