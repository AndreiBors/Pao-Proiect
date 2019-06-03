package Pachet;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

public class Dealer implements Serializable {
    private List<Car> owned_cars=new java.util.ArrayList<>();
    private HashSet<Integer> leasing_cars=new java.util.HashSet<>();
    private List<Status>leasing_details=new java.util.ArrayList<>();
    private String city;
    private String name;
    private Integer budget;
    //private static int ID=0;
    //private final int objectId;

    public Dealer(List<Car> owned_cars, HashSet<Integer> leasing_cars, List<Status> leasing_details, String city, String name, Integer budget, int objectId) {
        this.owned_cars = owned_cars;
        this.leasing_cars = leasing_cars;
        this.leasing_details = leasing_details;
        this.city = city;
        this.name = name;
        this.budget = budget;
        //this.objectId = objectId;
    }

    public Dealer(List<Car> available_cars, String Name, String city, Integer budget)
    {
        //objectId=ID;
        //ID++;
        this.budget=0;
        this.name=Name;
        this.owned_cars = available_cars;
        this.city=city;
        this.budget=budget;
    }
    public Dealer(List<Car> available_cars,String Name,String city)
    {
        //objectId=ID;
        //ID++;
        this.budget=0;
        this.name=Name;
        this.owned_cars = available_cars;
        this.city=city;
    }
    public Dealer()
    {
        //objectId=ID;
        //ID++;
        this.budget=0;
    }
    public Dealer(String name,String city)
    {
        //objectId=ID;
        //ID++;
        this.budget=0;
        this.city=city;
        this.name=name;
    }
    public Dealer(String name,String city,Integer budget)
    {
        //objectId=ID;
        //ID++;
        this.budget=budget;
        this.city=city;
        this.name=name;
    }
    public void addCar(Car x)
    {
        owned_cars.add(x);
    }
    public Boolean Search_car(Car c)
    {
        for(int i=0;i<owned_cars.size();i++)
            if(c.equals(owned_cars.get(i)))return true;
        return false;
    }
    public Boolean Search_car(String Name)
    {
        for(int i=0;i<owned_cars.size();i++)
            if(Name.equals(owned_cars.get(i).get_name()))return true;
        return false;
    }

    public int sellEachCar(Car c)
    {
        int price=0;
        for(int i=0;i<owned_cars.size();i++)if(c.equals(owned_cars.get(i)))
        {
            price= price+owned_cars.get(i).get_price();
            budget = budget + owned_cars.get(i).get_price();
            owned_cars.remove(i);
            i=i-1;
        }
        return price;
    }

    public int sellEachCar(String name)
    {   int price=0;
        for(int i=0;i<owned_cars.size();i++)if(name.equals(owned_cars.get(i).get_name()))
        {
            price=price+owned_cars.get(i).get_price();
            budget = budget + owned_cars.get(i).get_price();
            owned_cars.remove(i);
            i=i-1;
        }
        return price;
    }


    public int sellCar(Car c)
    {   int price=0;
        for(int i=0;i<owned_cars.size();i++)if(c.equals(owned_cars.get(i)))
        {   price=owned_cars.get(i).get_price();
            budget = budget + owned_cars.get(i).get_price();
            owned_cars.remove(i);
            break;
        }
        return price;
    }
    public int sellCar(int index)
    {
        int price=owned_cars.get(index).get_price();
        budget = budget + owned_cars.get(index).get_price();
        owned_cars.remove(index);
     return price;
    }
    public int sellCar(String name)
    {int price=0;
        for(int i=0;i<owned_cars.size();i++)if(name.equals(owned_cars.get(i).get_name()))
        {
            price=owned_cars.get(i).get_price();
            budget=budget+owned_cars.get(i).get_price();
            owned_cars.remove(i);
            break;
        }
    return price;
    }
   int leasecar(Car c,int sum)
    {   if(sum<c.get_price())
        {
        int i;
        for(i=0;i<owned_cars.size();i++)if(c.get_name().equals(owned_cars.get(i).get_name()))break;
        leasing_cars.add(i);
        Status S=new Status(owned_cars.get(i).get_price(),sum,i);
        leasing_details.add(S);
        budget=budget+sum;
        return leasing_details.size()-1;
        }
        else System.out.println("Bani suficienti pentru a achizitiona");
        return -1;
    }
    int pay_lease(int i,int sum)
    {
        if(leasing_details.get(i).get_rest()>sum)
        {
            budget=budget+sum;
            leasing_details.get(i).decrease_rest(sum);
            return 0;
        }
        else
        {
         int rest = sum - leasing_details.get(i).get_rest();
         budget = budget + leasing_details.get(i).get_rest();
         int j = leasing_details.get(i).get_index();
         leasing_details.remove(i);
         leasing_cars.remove(j);
         owned_cars.remove(j);
         return  rest;
        }
    }
    int leasing_sum(int index)
    {
        return leasing_details.get(index).get_rest();
    }



    /*public void printclass()
    {
        java.util.Scanner S=new java.util.Scanner(System.in);
        String c_name="com.Pachet."+S.next();
        for(int i=0;i<available_cars.size();i++)if (Class.forName(c_name).isInstance(available_cars.get(i)))available_cars.get(i).print();
    }*/
    public void printconsole()
    {
        System.out.println("Name: "+name+"; City: "+city+"; Budget: "+budget);
        System.out.println();

        for(int i=0;i<owned_cars.size();i++)
        {
            owned_cars.get(i).print();
            if(leasing_cars.contains(i))System.out.println("Din Leasing");
        }
        System.out.println("====================================================");

    }
}
