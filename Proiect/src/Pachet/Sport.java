package Pachet;

public class Sport extends Car {
    private Integer Hp;
    public Sport(Integer price, Integer width, Integer length, Integer height, String name,String color, Integer hp) {
        super(price, width, length, height, name,color);
        Hp = hp;
    }
    public Sport() {}
    public void print()
    {
        super.print();
        System.out.println("horsepower: "+Hp);
        System.out.println("--------------------------------------------");
    }
}
