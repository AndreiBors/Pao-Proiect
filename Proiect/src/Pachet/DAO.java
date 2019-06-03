package Pachet;

public interface DAO<T>
{
    public void write(T entity,String filename);
    public T read(String filename);


}
