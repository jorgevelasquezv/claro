package co.com.claro.services;

import co.com.claro.configs.ClientServicesQualifier;
import co.com.claro.configs.EquipmentServicesQualifier;
import co.com.claro.entity.Client;
import co.com.claro.repositories.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
@ClientServicesQualifier
public class ClientServiceImpl implements Service<Client> {

    @Inject
    private CrudRepository<Client> repository;

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Client> find(Client client) {
        return Optional.ofNullable(repository.find(client));
    }

    @Override
    public Optional<Client> save(Client client) {
        return Optional.ofNullable(repository.save(client));
    }

    @Override
    public void delete(Client client) {
        repository.delete(client);
    }
}
