package Pachet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Service<T>implements DAO<T> {
    public void write(T entity,String filename)
    {
        try{
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(entity);
            oos.close();}
        catch(Exception E){E.printStackTrace();}
    }

    public T read(String filename)
    {
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
             T result= (T) ois.readObject();
            ois.close();
            return result;}
        catch(Exception E){E.printStackTrace();}
    return null;
    }
}


