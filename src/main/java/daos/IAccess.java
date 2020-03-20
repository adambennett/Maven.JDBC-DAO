package daos;

import java.util.*;

public interface IAccess<T> {
    public T findById(int id);
    public List<T> findAll();
    public Boolean update(T dto);
    public Boolean create(T dto);
    public Boolean delete(int id);
}
