package co.com.claro.controllers;

import co.com.claro.configs.TypeVendorServicesQualifier;
import co.com.claro.entity.TypeVendor;
import co.com.claro.services.Service;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

import java.util.List;

@Model
public class TypeVendorController {

    private TypeVendor typeVendor;

    private Long id;

    private List<TypeVendor> listTypeVendors;

    @Inject
    @TypeVendorServicesQualifier
    private Service<TypeVendor> service;


    @PostConstruct
    public void init(){
        this.listTypeVendors = service.findAll();
    }

    @Produces
    @Model
    public TypeVendor typeVendor(){
        this.typeVendor = new TypeVendor();
        if (id != null && id > 0 ){
            typeVendor.setId(id);
            service.find(typeVendor).ifPresent(v -> {
                this.typeVendor = v;
            });
        }
        return typeVendor;
    }

    @Produces
    @Model
    public List<TypeVendor> listTypeVendors(){
        return service.findAll();
    }

    public String save(){
        service.save(typeVendor);
        this.listTypeVendors = service.findAll();
        return "type-vendors.xhtml";
    }

    public String edit(Long id){
        this.id = id;
        return "form-type-vendor.xhtml";
    }

    public void delete(Long id){
        service.delete(service.find(TypeVendor.builder().id(id).build()).get());
        this.listTypeVendors = service.findAll();
    }

    public TypeVendor getTypeVendor() {
        return typeVendor;
    }

    public void setTypeVendor(TypeVendor typeVendor) {
        this.typeVendor = typeVendor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TypeVendor> getListTypeVendors() {
        return listTypeVendors;
    }

    public void setListTypeVendors(List<TypeVendor> listTypeVendors) {
        this.listTypeVendors = listTypeVendors;
    }
}
