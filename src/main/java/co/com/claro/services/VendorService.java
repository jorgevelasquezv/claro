package co.com.claro.services;

import co.com.claro.entity.Vendor;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface VendorService {

    List<Vendor> findAll();

    Optional<Vendor> find(Vendor vendor);

    Optional<Vendor> save(Vendor vendor);

    void delete(Vendor vendor);
}
