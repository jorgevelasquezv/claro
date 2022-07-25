package co.com.claro.services;

import co.com.claro.entity.Vendor;
import co.com.claro.repositories.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
public class VendorServiceImpl implements VendorService {

    @Inject
    private CrudRepository<Vendor> repository;

    @Override
    public List<Vendor> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Vendor> find(Vendor vendor) {
        return Optional.ofNullable(repository.find(vendor));
    }

    @Override
    public Optional<Vendor> save(Vendor vendor) {
        return Optional.ofNullable(repository.save(vendor));
    }

    @Override
    public void delete(Vendor vendor) {
        repository.delete(vendor);
    }
}
