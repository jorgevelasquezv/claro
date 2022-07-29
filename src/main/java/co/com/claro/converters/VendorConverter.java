package co.com.claro.converters;

import co.com.claro.configs.VendorServicesQualifier;
import co.com.claro.entity.Vendor;
import co.com.claro.services.Service;
import jakarta.enterprise.inject.Model;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;

import java.util.Optional;

@Model
public class VendorConverter implements Converter<Vendor> {

    @Inject
    @VendorServicesQualifier
    private Service<Vendor> service;

    @Override
    public Vendor getAsObject(FacesContext context, UIComponent component, String id) {
        if (id == null){
            return null;
        }
        Optional<Vendor> VendorOptional = service.find(Vendor.builder().id(Long.valueOf(id)).build());
        if (VendorOptional.isPresent()){
            return VendorOptional.get();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Vendor vendor) {
        if (vendor == null){
            return "0";
        }
        return vendor.getId().toString();
    }
}
