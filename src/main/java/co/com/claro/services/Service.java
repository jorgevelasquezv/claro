package co.com.claro.services;

import java.util.List;

public interface Service<T> {

    T save (T t);

    T find(T t);

    List<T> findAll();

    void delete (T t);

}
