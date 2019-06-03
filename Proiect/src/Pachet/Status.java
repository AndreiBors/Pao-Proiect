package Pachet;

import java.io.Serializable;

public class Status implements Serializable {
    private int suma_totala;
    private int suma_achitata;
    private boolean statut;
    private int index;
    //0 nedisponibila ,1 disponibila

    public Status() {}
    public Status(int suma_totala, int suma_achitata,int index) {
        this.suma_totala = suma_totala;
        this.suma_achitata = suma_achitata;
        this.statut =false;
        this.index = index;
    }
    public int get_rest()
    {
     return suma_totala-suma_achitata;
    }
    public void decrease_rest(int sum)
    {
        suma_achitata=suma_achitata+sum;
    }
    public int get_index()
    {
        return index;
    }
}
