package co.com.claro.controllers;

import co.com.claro.configs.EquipmentServicesQualifier;
import co.com.claro.configs.SaleServicesQualifier;
import co.com.claro.configs.VendorServicesQualifier;
import co.com.claro.entity.Client;
import co.com.claro.entity.Equipment;
import co.com.claro.entity.Sale;
import co.com.claro.entity.Vendor;
import co.com.claro.services.Service;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

import java.util.List;

@Model
public class SaleController {

    private Sale sale;

    private Long id;

    private List<Sale> sales;

    private Equipment equipment;

    private Vendor vendor;

    private Client client;

    private List<Equipment> equipments;

    private List<Vendor> vendors;

    @Inject
    @SaleServicesQualifier
    private Service<Sale> service;

    @Inject
    @VendorServicesQualifier
    private Service<Vendor> vendorService;

    @Inject
    @EquipmentServicesQualifier
    private Service<Equipment> equipmentService;

    @PostConstruct
    public void init() {
        this.sales = service.findAll();
    }

    @Produces
    @Model
    public Sale sale() {
        this.sale = new Sale();
        this.vendor = new Vendor();
        this.equipment = new Equipment();
        this.client = new Client();

        if (id != null && id > 0) {
            sale.setId(id);
            service.find(sale).ifPresent(s -> {
                this.sale = s;
                this.client = s.getClient();
                this.equipment = s.getEquipment();
                this.vendor = s.getVendor();
            });
        }
        return sale;
    }

    @Produces
    @Model
    public List<Vendor> vendors() {
        return vendorService.findAll();
    }

    @Produces
    @Model
    public List<Equipment> equipments() {
        return equipmentService.findAll();
    }

    public String save(Long id) {
        this.sale.setClient(client);
        if (id == null || id == 0) {
            this.equipment = this.sale.getEquipment();
            this.equipment.setQuantity(this.sale.getEquipment().getQuantity() - 1);
            equipmentService.save(this.equipment);
        }
        service.save(sale);
        this.sales = service.findAll();
        System.out.println("*********** Sale Save **************** " + sale + "******* ID ******** " + id);
        return "sales.xhtml";
    }

    public String edit(Long id) {
        this.id = id;
        return "form-sale.xhtml";
    }

    public void delete(Long id) {
        service.delete(service.find(Sale.builder().id(id).build()).get());
        this.sales = service.findAll();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
