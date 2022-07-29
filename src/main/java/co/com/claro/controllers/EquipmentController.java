package co.com.claro.controllers;

import co.com.claro.configs.EquipmentServicesQualifier;
import co.com.claro.entity.Equipment;
import co.com.claro.services.Service;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

import java.util.List;

@Model
public class EquipmentController {

    @Inject
    @EquipmentServicesQualifier
    private Service<Equipment> service;

    private  Equipment equipment;

    private Long id;

    private List<Equipment> equipments;

    @PostConstruct
    private void init(){
        this.equipments = service.findAll();
    }

    @Produces
    @Model
    public Equipment equipment(){
        this.equipment = new Equipment();
        if (id != null && id > 0 ){
            equipment.setId(id);
            service.find(equipment).ifPresent(v -> {
                this.equipment = v;
            });
        }
        return this.equipment;
    }

    public String save(){
        service.save(equipment);
        this.equipments = service.findAll();
        return "equipments.xhtml";
    }

    public String edit(Long id){
        this.id = id;
        return "form-equipment.xhtml";
    }

    public void delete(Long id){
        service.delete(service.find(Equipment.builder().id(id).build()).get());
        this.equipments = service.findAll();
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
