package Pachet;

import java.util.ArrayList;

public  class ClientJ extends Comand {

    private java.util.List<Integer> plati =new ArrayList<>();
    public void  leasecar(Car c,Dealer D)
    {
        int sum=10000;
        int chitanta=D.leasecar(c,sum);
        if(chitanta>-1)plati.add(chitanta);
    }
    public int pay_lease(Dealer D)
    {
        int sum=16000;
        int rest;
        rest=D.pay_lease(plati.get(0),sum);
        while(rest>0&&plati.size()>1){
            plati.remove(0);
            System.out.println(rest);
            rest=D.pay_lease(plati.get(0),rest);
        }
        return rest;
    }
    public void print(){
        for(int i=0;i<plati.size();i++)System.out.println(plati.get(i));
    }
    public Integer TOTAL(Dealer D)
    {
        Integer total=0;
        for(Integer chitanta_id:plati)
        {
         total=total+D.leasing_sum(chitanta_id);
        }
        return total;
    }
}

