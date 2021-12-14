package com.app.retos.ciclo4.appG16.appG16.controller;

import com.app.retos.ciclo4.appG16.appG16.model.Cookware;
import com.app.retos.ciclo4.appG16.appG16.service.CookwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cookware")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class CookwareController {
    @Autowired
    private CookwareService cookwareService;

    @GetMapping("/all")
    public List<Cookware> getAll() {
        return cookwareService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Cookware> getCookware(@PathVariable("reference") String reference) {
        return cookwareService.getCookware(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware create(@RequestBody Cookware cookware) {
        return cookwareService.saveCookware(cookware);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware update(@RequestBody Cookware cookware) {
        return cookwareService.updateCookware(cookware);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return cookwareService.deleteCookware(reference);
    }

    @GetMapping("/price/{price}")
    public List<Cookware> getByPrice(@PathVariable("price") String price) {
        return cookwareService.getProductByPrice(price);
    }
    @GetMapping("/description/{description}")
    public List<Cookware> getByDescription(@PathVariable("description") String description) {
        return cookwareService.getProductByDescription(description);
    }

}
