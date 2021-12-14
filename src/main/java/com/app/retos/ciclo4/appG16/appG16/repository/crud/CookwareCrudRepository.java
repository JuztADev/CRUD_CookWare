package com.app.retos.ciclo4.appG16.appG16.repository.crud;


import com.app.retos.ciclo4.appG16.appG16.model.Cookware;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CookwareCrudRepository extends MongoRepository<Cookware,String> {

    @Query("{'price': {$lte:?0}}")
    List<Cookware> findByPrice(double price);

    @Query("{'description': {$regex:?0,$options:'i'}}")
    List<Cookware> findByDescription(String description);

}
