package com.app.retos.ciclo4.appG16.appG16.repository;

import com.app.retos.ciclo4.appG16.appG16.model.User;
import com.app.retos.ciclo4.appG16.appG16.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll(){
        return userCrudRepository.findAll();
    }
    public Optional<User> getUser(Integer idUser){
        return userCrudRepository.findById(idUser);
    }
    public User saveUser(User user){
        return userCrudRepository.save(user);

    }
    public Optional<User> getUserByEmail(String email){
        return userCrudRepository.findUserByEmail(email);
    }
    public Optional<User> getByEmailAndPassword(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    public void deleteUser(User user) {
        userCrudRepository.delete(user);
    }

    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }

    public List<User> getUsersBymonthBirthtDay(String monthBirthtDay){
        return userCrudRepository.findmonthBirthDay(monthBirthtDay);
    }

}
