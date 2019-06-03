package Pachet;

public class Station_Wagon extends Car {
    private Integer seats;

    public Station_Wagon(Integer price, Integer width, Integer length, Integer height, String name,String color, Integer Seats) {
        super(price, width, length, height, name,color);
        seats = Seats;
    }
    public Station_Wagon() {}

    public void print()
    {
        super.print();
        System.out.println("Seats: "+seats);
        System.out.println("--------------------------------------------");
    }
}
