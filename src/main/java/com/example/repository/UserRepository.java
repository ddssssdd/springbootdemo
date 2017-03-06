package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by stevenfu on 04/03/2017.
 */

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByEmail(String email);

    @Query("select u from User u where u.email = ?1")
    List<User> findByQuery(String email);

    @Query(value = "select * from users where email = ?1", nativeQuery=true)
    List<User> findByQuery2(String email);
}
