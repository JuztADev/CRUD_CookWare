package com.app.retos.ciclo4.appG16.appG16.repository.crud;

import com.app.retos.ciclo4.appG16.appG16.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<User,Integer> {
    @Query("{email: ?0,password: ?1}")
    Optional<User> findByEmailAndPassword(@Param("email") String email,
                                    @Param("password") String password);

    @Query("{email: ?0}")
    Optional<User> findUserByEmail(String email);

    Optional<User> findTopByOrderByIdDesc();

    @Query("{monthBirthtDay: ?0}")
    List<User> findmonthBirthDay(String monthBirthtDay);
}
