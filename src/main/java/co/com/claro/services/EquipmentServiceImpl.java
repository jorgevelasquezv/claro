package co.com.claro.services;

import co.com.claro.configs.EquipmentServicesQualifier;
import co.com.claro.entity.Equipment;
import co.com.claro.repositories.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
@EquipmentServicesQualifier
public class EquipmentServiceImpl implements Service<Equipment> {

    @Inject
    private CrudRepository<Equipment> repository;

    @Override
    public List<Equipment> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Equipment> find(Equipment equipment) {
        return Optional.ofNullable(repository.find(equipment));
    }

    @Override
    public Optional<Equipment> save(Equipment equipment) {
        return Optional.ofNullable(repository.save(equipment));
    }

    @Override
    public void delete(Equipment equipment) {
        repository.delete(equipment);
    }
}
