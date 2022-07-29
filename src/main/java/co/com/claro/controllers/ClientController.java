package co.com.claro.controllers;

import co.com.claro.configs.ClientServicesQualifier;
import co.com.claro.entity.Client;
import co.com.claro.services.Service;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

import java.util.List;

@Model
public class ClientController {

    @Inject
    @ClientServicesQualifier
    private Service<Client> service;

    private  Client client;

    private Long id;

    private List<Client> clients;

    @PostConstruct
    private void init(){
        this.clients = service.findAll();
    }

    @Produces
    @Model
    public Client client(){
        this.client = new Client();
        if (id != null && id > 0 ){
            client.setId(id);
            service.find(client).ifPresent(v -> {
                this.client = v;
            });
        }
        return this.client;
    }

    public String save(){
        service.save(client);
        this.clients = service.findAll();
        return "clients.xhtml";
    }

    public String edit(Long id){
        this.id = id;
        return "form-client.xhtml";
    }

    public void delete(Long id){
        service.delete(service.find(Client.builder().id(id).build()).get());
        this.clients = service.findAll();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
