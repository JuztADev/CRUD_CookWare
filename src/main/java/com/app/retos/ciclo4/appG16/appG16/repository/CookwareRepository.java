package com.app.retos.ciclo4.appG16.appG16.repository;

import com.app.retos.ciclo4.appG16.appG16.model.Cookware;
import com.app.retos.ciclo4.appG16.appG16.repository.crud.CookwareCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CookwareRepository {
    @Autowired
    private CookwareCrudRepository cookwareCrudRepository;

    public List<Cookware> getAll() {
        return cookwareCrudRepository.findAll();
    }

    public Optional<Cookware> getCookware(String reference) {
        return cookwareCrudRepository.findById(reference);
    }
    public Cookware saveCookware(Cookware cookware) {
        return cookwareCrudRepository.save(cookware);
    }

    public void deleteCookware(Cookware cookware) {
        cookwareCrudRepository.delete(cookware);
    }
    public List<Cookware> getProductbyPrice(double price){
        return cookwareCrudRepository.findByPrice(price);
    }
    public List<Cookware> getProductByDescription(String description){
        return  cookwareCrudRepository.findByDescription(description);
    }
}
