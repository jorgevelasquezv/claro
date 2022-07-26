package co.com.claro.services;

import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface Service<T> {

    List<T> findAll();

    Optional<T> find(T t);

    Optional<T> save(T t);

    void delete(T t);
}
