package co.com.claro.repositories;

import java.util.List;

public interface CrudRepository<T> {

    T save (T t);

    T find(T t);

    List<T> findAll();

    void delete (T t);

}
