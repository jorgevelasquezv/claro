package co.com.claro.services;

import co.com.claro.configs.SaleServicesQualifier;
import co.com.claro.entity.Sale;
import co.com.claro.repositories.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
@SaleServicesQualifier
public class SaleServiceImpl implements Service<Sale> {

    @Inject
    private CrudRepository<Sale> repository;

    @Override
    public List<Sale> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Sale> find(Sale sale) {
        return Optional.ofNullable(repository.find(sale));
    }

    @Override
    public Optional<Sale> save(Sale sale) {
        return Optional.ofNullable(repository.save(sale));
    }

    @Override
    public void delete(Sale sale) {
        repository.delete(sale);
    }
}
