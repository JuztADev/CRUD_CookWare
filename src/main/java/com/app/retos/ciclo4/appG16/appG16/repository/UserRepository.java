package com.app.retos.ciclo4.appG16.appG16.repository;

import com.app.retos.ciclo4.appG16.appG16.model.User;
import com.app.retos.ciclo4.appG16.appG16.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
/**
 * Creacion de la clase UserRepository para implementar los metodos de la clase UserCrudRepository
 */
public class UserRepository {
    /**
     * Llamado de la clase UserCrudRepository para uso de los metodos previamente creados
     */
    @Autowired
    private UserCrudRepository userCrudRepository;
    /**
     * metodo para obtener todos los datos de la coleccion users
     * @return
     */
    public List<User> getAll(){
        return userCrudRepository.findAll();
    }
    /**
     * metodo para obtener un solo dato de la coleccion users por medio de su id
     * @param idUser
     * @return
     */
    public Optional<User> getUser(Integer idUser){
        return userCrudRepository.findById(idUser);
    }

    /**
     * metodo para guardar y actualizar un usuario en la coleccion
     * @param user
     * @return
     */
    public User saveUser(User user){
        return userCrudRepository.save(user);

    }
    /**
     * metodo para obtener un usuario de la coleccion por medio de su email
     * @param email
     * @return
     */
    public Optional<User> getUserByEmail(String email){
        return userCrudRepository.findUserByEmail(email);
    }
    /**
     * metodo para conocer si el correo y la contraseña coninciden con los almacenados en la coleccion
     * @param email
     * @param password
     * @return
     */
    public Optional<User> getByEmailAndPassword(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    /**
     * metodo para eliminar un usuario de la coleccion
     * @param user
     * @return
     */
    public void deleteUser(User user) {
        userCrudRepository.delete(user);
    }

    /**
     * metodo para obtener el ultimo id de la coleccion
     * @return
     */
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    /**
     * metodo para obtener una lista de usuarios segun su mes de cumpleaños
     * @param monthBirthtDay
     * @return
     */
    public List<User> getUsersBymonthBirthtDay(String monthBirthtDay){
        return userCrudRepository.findmonthBirthDay(monthBirthtDay);
    }

}
