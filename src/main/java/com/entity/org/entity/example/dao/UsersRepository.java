package com.entity.org.entity.example.dao;

import com.entity.org.entity.example.model.UserName;
import com.entity.org.entity.example.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUserId(int id);

    Users findByUserIdAndUsername(int id, String userName);

    Users findByUserIdOrUsername(int id, String userName);

    List<UserName> findByFirstName(String firstName);

    @Query(nativeQuery = true, value = "SELECT first_name, user_id FROM PUBLIC.users")
    List<String> findAbc();

    @Query("select count(u) from Users u")
    long countAll();

}
