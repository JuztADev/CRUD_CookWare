package com.app.retos.ciclo4.appG16.appG16.controller;


import com.app.retos.ciclo4.appG16.appG16.model.User;
import com.app.retos.ciclo4.appG16.appG16.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin (origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
/**
 * Creacion de la clase usercontroller para que mediante esta se puedan realizar las peticiones
 * a la base de datos por medio de una url
 */
public class UserController {
    /**
     * Llamado de la clase UserService para uso de metodos previamente establecidos
     */
    @Autowired
    private UserService userService;

    /**
     * Metodo para obtener todos los datos de la coleccion users
     * @return
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    /**
     * metodo para obtener un dato de la coleccion mediante su id
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<User> getUserById(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    /**
     * metodo para saber si un email se encuentra en uso o no
     * @param email
     * @return
     */
    @GetMapping("emailexist/{email}")
    public boolean getUserByEmail(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }

    /**
     * metodo para saber si la combinacion de correo contraseña es valida
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User getByUserEmailAndUserPassword(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.getByEmailAndPassword(email,password);
    }

    /**
     * metodo para crear un nuevo usuario
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    /**
     * metodod para actualizar un dato de una coleccion
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user){

        return userService.updateUser(user);
    }

    /**
     * metodo para eliminar un dato de la coleccion mediante su id
     * @param idUser
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUser(@PathVariable("id") int idUser) {
        return userService.deleteUser(idUser);
    }

    @GetMapping("/birthday/{monthBirthtDay}")
    public List<User> getUserbymonthBirthtDay(@PathVariable("monthBirthtDay") String monthBirthtDay) {
        return userService.getUserBymonthBirthtDay(monthBirthtDay);

    }

}