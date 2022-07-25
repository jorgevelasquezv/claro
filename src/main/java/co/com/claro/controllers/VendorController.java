package co.com.claro.controllers;

import co.com.claro.entity.TypeVendor;
import co.com.claro.entity.Vendor;
import co.com.claro.services.TypeVendorService;
import co.com.claro.services.VendorService;
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

    @Inject
    private VendorService service;

    @Inject
    private TypeVendorService typeVendorService;

    @Produces
    @RequestScoped
    @Named("vendors")
    public List<Vendor> findAll(){
        return service.findAll();
    }

    @Produces
    @Model
    public Vendor vendor(){
        this.vendor = new Vendor();
        this.typeVendor = new TypeVendor();
        this.vendor.setTypeVendor(typeVendor);

        if (id != null && id > 0 ){
            vendor.setId(id);
            service.find(vendor).ifPresent(v -> {
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
        System.out.println(vendor.getTypeVendor());
        service.save(vendor);
        return "index.xhtml?faces-redirect=true";
    }

    public String edit(Long id){
        this.id = id;
        return "form.xhtml";
    }

    public String delete(Long id){
        service.delete(service.find(Vendor.builder().id(id).build()).get());
        return "index.xhtml?faces-redirect=true";
    }
}
