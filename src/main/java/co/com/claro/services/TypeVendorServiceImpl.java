package co.com.claro.services;

import co.com.claro.configs.TypeVendorServicesQualifier;
import co.com.claro.entity.TypeVendor;
import co.com.claro.repositories.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
@TypeVendorServicesQualifier
public class TypeVendorServiceImpl implements Service<TypeVendor>{

    @Inject
    private CrudRepository<TypeVendor> repository;

    @Override
    public List<TypeVendor> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TypeVendor> find(TypeVendor typeVendor) {
        return Optional.ofNullable(repository.find(typeVendor));
    }

    @Override
    public Optional<TypeVendor> save(TypeVendor typeVendor) {
        return Optional.empty();
    }

    @Override
    public void delete(TypeVendor typeVendor) {

    }
}
