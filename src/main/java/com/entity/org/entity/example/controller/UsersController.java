package com.entity.org.entity.example.controller;

import com.entity.org.entity.example.dao.UsersRepository;
import com.entity.org.entity.example.dto.UsersDto;
import com.entity.org.entity.example.model.UserName;
import com.entity.org.entity.example.model.Users;
import com.entity.org.entity.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {

    UsersService usersService;

    UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersService usersService, UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/getAll")
    public List<Users> getAllUsers(){
        return  usersService.getAllUsers();
    }

    @GetMapping("/getUsers")
    public Map<String, Long> getUsers(){
        return usersService.getUsers();
    }

    @GetMapping("/getAllCounts")
    public Map<Object, List<Users>> getAlls(){
        return usersService.getAlls();
    }

    @GetMapping("/getAllCount")
    public Map<Long, List<Users>> getAll(){
        return usersService.getAll();
    }

    @PostMapping("/setUser")
    public Users setUsers(@RequestBody Users users) {
        return usersService.setUsers(users);
    }

    @GetMapping("/user")
    public Users getUserById(@RequestParam int id){
        return usersService.getUserById(id);
    }

    @GetMapping("/user/{id}/{userName}")
    public Users getUserByIdAndUsername(@PathVariable int id, @PathVariable String userName){
        return usersService.getUserByIdAndByName(id, userName);
    }

    @GetMapping("/users/{id}/{userName}")
    public Users getUserByIdOrName(@PathVariable int id, @PathVariable String userName) {
        return usersService.getByIdOrName(id, userName);
    }

    @PutMapping("/update")
    public Users updateUser(@RequestBody Users users) {
        return usersService.updateUser(users);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return usersService.deleteUser(id);
    }

    @PatchMapping("/patch/{userId}")
    public void patchUser(@PathVariable int userId, @RequestBody UsersDto usersDto){
        Users users =usersRepository.findByUserId(userId);
        users.setFirstName(usersDto.getFirstName());
        usersRepository.save(users);
    }

    @GetMapping("/projection")
    public List<UserName> projection(@RequestBody Users users){
        List<UserName> findByUserFirstName = usersRepository.findByFirstName(users.getFirstName()); //"Ashish" (hard-code by self without using @RequestBody int parameter !!)
        for (UserName userName: findByUserFirstName) {
//            System.out.print("userId :" + userName.getUserId());
//            System.out.println(", firstName :" + userName.getFirstName());
            userName.getUserId();
            userName.getFirstName();
//            userName.getClass();
        }
        return findByUserFirstName;
    }


    @GetMapping("/userAbc")
    public List<String> getUsersByName() {
        return usersRepository.findAbc();
    }

    @GetMapping("/getAllCountUser")
    public long getCount(){
        return usersRepository.countAll();
    }


//    add exception packages
}
