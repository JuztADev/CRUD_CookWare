package com.app.retos.ciclo4.appG16.appG16.service;

import com.app.retos.ciclo4.appG16.appG16.model.User;
import com.app.retos.ciclo4.appG16.appG16.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**
 * Creacion de la clase userservice para implementar los metodos de la clase UserRepository
 */
public class UserService {
    /**
     * Llamado de la clase Userrepository para uso de los metodos previamente creados
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * metodo para obtener todos los datos de la coleccion users
     * @return
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * metodo para obtener un solo dato de la coleccion users por medio de su id
     * @param idUser
     * @return
     */
    public Optional<User> getUser(Integer idUser){
        return userRepository.getUser(idUser);
    }

    /**
     * metodo para guardar un usuario en la coleccion
     * @param user
     * @return
     */
    public User saveUser(User user) {
        Optional<User> userIdMaximo = userRepository.lastUserId();
        if (user.getId() == null) {
            if (userIdMaximo.isEmpty())
                user.setId(1);
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
        Optional<User> e = userRepository.getUser(user.getId());
        if (e.isEmpty()) {
            if (getUserByEmail(user.getEmail())==false){
                return userRepository.saveUser(user);
            }else{
                return user;
            }
        }else{
            return user;
        }

    }

    /**
     * metodo para obtener un usuario de la coleccion por medio de su email
     * @param email
     * @return
     */
    public boolean getUserByEmail(String email){
        return userRepository.getUserByEmail(email).isPresent();
    }

    /**
     * metodo para conocer si el correo y la contraseña coninciden con los almacenados en la coleccion
     * @param email
     * @param password
     * @return
     */
    public User getByEmailAndPassword(String email,String password){
        Optional<User> user= userRepository.getByEmailAndPassword(email,password);
        User tempuser = new User();

        if(user.isPresent()){
            return user.get();
        }
        return tempuser;


    }

    /**
     * metodo para actualizar un usuario de la coleccion
     * @param user
     * @return
     */
    public User updateUser(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                if (user.getType() !=null){
                    userDb.get().setType(user.getType());
                }
                userRepository.saveUser(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * metodo para eliminar un usuario de la coleccion mediante su id
     * @param userId
     * @return
     */
    public boolean deleteUser(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.deleteUser(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * metodo para obtener una lista de usuarios segun su mes de cumpleaños
     * @param monthBirthtDay
     * @return
     */
    public List<User> getUserBymonthBirthtDay(String monthBirthtDay){
        return userRepository.getUsersBymonthBirthtDay(monthBirthtDay);
    }

}
