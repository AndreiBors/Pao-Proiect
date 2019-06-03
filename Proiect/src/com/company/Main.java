package com.company;

import Pachet.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class Main {

    public static void main(String[] args)
    {
        List<Car> owned_cars=new ArrayList<>();
        HashSet<Integer> leasing_cars=new HashSet<>();
        List<Status> leasing_details=new ArrayList<>();
        Dealer FordBuc=new Dealer(owned_cars,leasing_cars,leasing_details,"Bucharest","Ford Bucuresti Nord",0,0);
        FordBuc.addCar(new Hatchback(34490,1825,4378,1454,"Ford_Focus","Grena",5));
        //FordBuc.addCar(new Sport(400000,1950,4640,1130,"Ford_GT",550));
        FordBuc.addCar(new Station_Wagon(42000,1852,4867,1501,"Ford_Mondeo","Negru",5));
        FordBuc.addCar(new Station_Wagon(40000,1852,4867,1501,"Ford_BMAX","Gri",7));
        FordBuc.addCar(new Hatchback(40000,1852,4867,1501,"Ford_Fiesta","Albastru",3));
        Car c=new Station_Wagon(42000,1852,4867,1501,"Ford_Mondeo","Negru",5);
        Car ca=new Hatchback(40000,1852,4867,1501,"Ford_Fiesta","Albastru",3);
        //Service Dealer
        Service<Dealer>SRV_dealer=new Service<>();
        SRV_dealer.write(FordBuc,"dealer.txt");
        Dealer FordBucBis=SRV_dealer.read("dealer.txt");
        FordBucBis.printconsole();


        //Service Car
        Car C1=new Car(38000,1879,5023,1480,"Mazda","Verde");
        Service<Car>SRV_car=new Service<Car>();
        SRV_car.write(C1,"car.txt");
        Car C2=SRV_car.read("car.txt");
        C2.print();

        //Functionalitati Dealer

        if(FordBuc.Search_car("Ford_CMAX"))
            System.out.println("Gasita");
        else System.out.println("Negasita");

        if(FordBuc.Search_car(C2))
            System.out.println("Gasita");
        else System.out.println("Negasita");

        if(FordBuc.Search_car("Ford_Mondeo"))
            System.out.println("Gasita");
        else System.out.println("Negasita");

        ClientJ PersJur=new ClientJ();

        PersJur.leasecar(c,FordBuc);
        PersJur.leasecar(ca,FordBuc);
        System.out.println(PersJur.TOTAL(FordBuc));
        PersJur.pay_lease(FordBuc);
        System.out.println(PersJur.TOTAL(FordBuc));





    }
}
