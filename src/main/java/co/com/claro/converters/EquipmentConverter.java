package co.com.claro.converters;

import co.com.claro.configs.EquipmentServicesQualifier;
import co.com.claro.configs.TypeVendorServicesQualifier;
import co.com.claro.entity.Equipment;
import co.com.claro.entity.TypeVendor;
import co.com.claro.services.Service;
import jakarta.enterprise.inject.Model;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;

import java.util.Optional;

@Model
public class EquipmentConverter implements Converter<Equipment> {

    @Inject
    @EquipmentServicesQualifier
    private Service<Equipment> service;

    @Override
    public Equipment getAsObject(FacesContext context, UIComponent component, String id) {
        if (id == null){
            return null;
        }
        Optional<Equipment> equipmentOptional = service.find(Equipment.builder().id(Long.valueOf(id)).build());
        if (equipmentOptional.isPresent()){
            return equipmentOptional.get();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Equipment equipment) {
        if (equipment == null){
            return "0";
        }
        return equipment.getId().toString();
    }
}
