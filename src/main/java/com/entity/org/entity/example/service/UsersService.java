package com.entity.org.entity.example.service;

import com.entity.org.entity.example.dao.UsersRepository;
import com.entity.org.entity.example.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersService{


    UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers() {
     return usersRepository.findAll();
    }

    public Map<String, Long> getUsers(){
        Map<String, Long> map = new HashMap<>();
        map.put("count", usersRepository.count());
        return map;
    }

    public Map<Long, List<Users>> getAll() {
        Map<Long, List<Users>> getAll = new HashMap<>();
        getAll.put(usersRepository.count(), usersRepository.findAll());
        return getAll;
    }

    public Map<Object, List<Users>> getAlls() {
        Map<Object, List<Users>> getAll = new HashMap<>();
        Object o = "count:" + usersRepository.count();
        getAll.put(o, usersRepository.findAll());
        return getAll;
    }

    public Users setUsers(Users users) {
        new Users();
        users.setUserId(users.getUserId());
        users.setFirstName(users.getFirstName());
        users.setLastName(users.getLastName());
        users.setUsername(users.getUsername());
        users.setPassword(users.getPassword());
        return usersRepository.save(users);
    }

    public Users getUserById(int id){
        return usersRepository.findByUserId(id);
    }

    public Users getUserByIdAndByName(int id, String userName) {
        return usersRepository.findByUserIdAndUsername(id, userName);
    }

    public Users getByIdOrName(int id, String userName) {
        return usersRepository.findByUserIdOrUsername(id, userName);
    }

    public Users updateUser(Users users) {
        Users users1 = usersRepository.findByUserId(users.getUserId());
        users1.setFirstName(users.getFirstName());
        users1.setLastName(users.getLastName());
        users1.setUsername(users.getUsername());
        users1.setPassword(users.getPassword());
        return usersRepository.save(users1);
    }

    public String deleteUser(int id){
        usersRepository.deleteById(id);
        return "Success";
    }

    public ResponseEntity<?> patchUser(int id) {
        Users users = usersRepository.findByUserId(id);
        users.setFirstName(users.getFirstName());
        usersRepository.save(users);
        return ResponseEntity.ok(users);  // in controller
    }
}
