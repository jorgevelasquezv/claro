package co.com.claro.converters;

import co.com.claro.configs.TypeVendorServicesQualifier;
import co.com.claro.entity.TypeVendor;
import co.com.claro.services.Service;
import jakarta.enterprise.inject.Model;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;

import java.util.Optional;

@Model
public class TypeVendorConverter implements Converter<TypeVendor> {

    @Inject
    @TypeVendorServicesQualifier
    private Service<TypeVendor> service;

    @Override
    public TypeVendor getAsObject(FacesContext context, UIComponent component, String id) {
        if (id == null){
            return null;
        }
        Optional<TypeVendor> typeVendorOptional = service.find(TypeVendor.builder().id(Long.valueOf(id)).build());
        if (typeVendorOptional.isPresent()){
            return typeVendorOptional.get();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, TypeVendor typeVendor) {
        if (typeVendor == null){
            return "0";
        }
        return typeVendor.getId().toString();
    }
}
