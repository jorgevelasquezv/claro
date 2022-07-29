package co.com.claro.controllers;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Model;

import java.io.Serializable;

@Model
public class MenuController {

    private String path;

    public String selectPath(){
        return path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        System.out.println("***** Path ***** " + path );
        this.path = path;
    }
}
