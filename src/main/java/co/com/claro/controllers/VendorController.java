package co.com.claro.controllers;

import co.com.claro.configs.TypeVendorServicesQualifier;
import co.com.claro.configs.VendorServicesQualifier;
import co.com.claro.entity.TypeVendor;
import co.com.claro.entity.Vendor;
import co.com.claro.services.Service;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Model
public class VendorController {

    private Vendor vendor;

    private TypeVendor typeVendor;

    private Long id;

    private List<Vendor> vendors;

    @Inject
    @VendorServicesQualifier
    private Service<Vendor> vendorService;

    @Inject
    @TypeVendorServicesQualifier
    private Service<TypeVendor> typeVendorService;


    @PostConstruct
    public void init(){
        this.vendors = vendorService.findAll();
    }

    @Produces
    @Model
    public Vendor vendor(){
        this.vendor = new Vendor();
        this.typeVendor = new TypeVendor();
        this.vendor.setTypeVendor(typeVendor);

        if (id != null && id > 0 ){
            vendor.setId(id);
            vendorService.find(vendor).ifPresent(v -> {
                this.vendor = v;
            });
        }

        return vendor;
    }

    @Produces
    @Model
    public List<TypeVendor> typeVendors(){
        return typeVendorService.findAll();
    }

    public String save(){
        vendorService.save(vendor);
        this.vendors = vendorService.findAll();
        return "index.xhtml";
    }

    public String edit(Long id){
        this.id = id;
        return "form-vendor.xhtml";
    }

    public void delete(Long id){
        vendorService.delete(vendorService.find(Vendor.builder().id(id).build()).get());
        this.vendors = vendorService.findAll();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }
}
