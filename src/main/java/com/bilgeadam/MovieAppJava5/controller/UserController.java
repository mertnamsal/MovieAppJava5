package com.bilgeadam.MovieAppJava5.controller;

import com.bilgeadam.MovieAppJava5.repository.entity.User;
import com.bilgeadam.MovieAppJava5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/create")
    public User createUser(String name,String surname,String email,String phone,String password,String userType){
      return   userService.createUser(name,surname,email,phone,password,userType);
    }
    @GetMapping("/findall")
    public List<User> findAll(){

        return userService.findAll();
    }

    @GetMapping("/orderbyname")
    public ResponseEntity< List<User>> findAllByOrderByName(){

        return ResponseEntity.ok(userService.findAllByOrderByName());
    }

    @GetMapping("/findbynamewithlike")
    public ResponseEntity< List<User>> findAllByNameLike(String name){

        return ResponseEntity.ok(userService.findAllByNameLike("%"+name+"%"));
    }
    @GetMapping("/containsemail")
    public ResponseEntity< List<User>> findAllByEmailContainingIgnoreCase(String value){
        return  ResponseEntity.ok(userService.findAllByEmailContainingIgnoreCase(value));
    }
    @GetMapping("/findbyemailendingwith")
    public ResponseEntity< List<User>> findAllByEmailEndingWith(String value){
        return ResponseEntity.ok(userService.findAllByEmailEndingWith(value));
    }
    @GetMapping("/login")
    public ResponseEntity<Boolean> existsByEmailAndPassword(String email,String password){

        return ResponseEntity.ok(userService.existsByEmailAndPassword(email,password));
    }

    @GetMapping("/login2")

    public ResponseEntity<?> login(String email,String password){

        try {
            return ResponseEntity.ok(userService.findOptionalByEmailAndPassword(email,password));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/passwordcontrol")
    public  ResponseEntity< List<User>> passwordLongerThan(int length){
        return ResponseEntity.ok(userService.passwordLongerThan(length));
    }
    @GetMapping("/passwordcontrol2")
    public  ResponseEntity< List<User>> passwordControl(int length){
        return ResponseEntity.ok(userService.passwordControl(length));
    }
}
