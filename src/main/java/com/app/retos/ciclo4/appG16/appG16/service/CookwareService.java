package com.app.retos.ciclo4.appG16.appG16.service;

import com.app.retos.ciclo4.appG16.appG16.model.Cookware;
import com.app.retos.ciclo4.appG16.appG16.repository.CookwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookwareService {
    @Autowired
    private CookwareRepository cookwareRepository;

    public List<Cookware> getAll() {
        return cookwareRepository.getAll();
    }

    public Optional<Cookware> getCookware(String reference) {
        return cookwareRepository.getCookware(reference);
    }

    public Cookware saveCookware(Cookware cookware) {
        if (cookware.getReference() == null) {
            return cookware;
        } else {
            return cookwareRepository.saveCookware(cookware);
        }
    }

    public Cookware updateCookware(Cookware cookware) {

        if (cookware.getReference() != null) {
            Optional<Cookware> cookwareDb = cookwareRepository.getCookware(cookware.getReference());
            if (!cookwareDb.isEmpty()) {

                if (cookware.getBrand()!= null) {
                    cookwareDb.get().setBrand(cookware.getBrand());
                }
                if (cookware.getCategory() != null) {
                    cookwareDb.get().setCategory(cookware.getCategory());
                }
                if (cookware.getMateriales()!=null){
                    cookwareDb.get().setMateriales(cookware.getMateriales());
                }
                if (cookware.getDimensiones()!=null){
                    cookwareDb.get().setDimensiones(cookware.getDimensiones());
                }
                if (cookware.getDescription() != null) {
                    cookwareDb.get().setDescription(cookware.getDescription());
                }
                if (cookware.getPrice() != 0.0) {
                    cookwareDb.get().setPrice(cookware.getPrice());
                }
                if (cookware.getQuantity() != 0) {
                    cookwareDb.get().setQuantity(cookware.getQuantity());
                }
                if (cookware.getPhotography() != null) {
                    cookwareDb.get().setPhotography(cookware.getPhotography());
                }
                cookwareDb.get().setAvailability(cookware.isAvailability());
                cookwareRepository.saveCookware(cookwareDb.get());
                return cookwareDb.get();
            } else {
                return cookware;
            }
        } else {
            return cookware;
        }
    }

    public boolean deleteCookware(String reference) {
        Boolean aBoolean = getCookware(reference).map(cookware -> {
            cookwareRepository.deleteCookware(cookware);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public List<Cookware> getProductByPrice(String price){
        double valor = Double.parseDouble(price);
        return cookwareRepository.getProductbyPrice(valor);
    }
    public List<Cookware> getProductByDescription(String description){
        return cookwareRepository.getProductByDescription(description);
    }

}

