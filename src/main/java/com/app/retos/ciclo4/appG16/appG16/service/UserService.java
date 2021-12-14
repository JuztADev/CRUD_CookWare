package com.app.retos.ciclo4.appG16.appG16.service;

import com.app.retos.ciclo4.appG16.appG16.model.User;
import com.app.retos.ciclo4.appG16.appG16.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(Integer idUser){
        return userRepository.getUser(idUser);
    }
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
    public boolean getUserByEmail(String email){
        return userRepository.getUserByEmail(email).isPresent();
    }

    public User getByEmailAndPassword(String email,String password){
        Optional<User> user= userRepository.getByEmailAndPassword(email,password);
        User tempuser = new User();

        if(user.isPresent()){
            return user.get();
        }
        return tempuser;


    }
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
    public boolean deleteUser(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.deleteUser(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<User> getUserBymonthBirthtDay(String monthBirthtDay){
        return userRepository.getUsersBymonthBirthtDay(monthBirthtDay);
    }

}
