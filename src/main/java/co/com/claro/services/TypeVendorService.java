package co.com.claro.services;

import co.com.claro.entity.TypeVendor;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface TypeVendorService {

    List<TypeVendor> findAll();

    Optional<TypeVendor> find(TypeVendor typeVendor);

    Optional<TypeVendor> save(TypeVendor typeVendor);

    void delete(TypeVendor typeVendor);
}
