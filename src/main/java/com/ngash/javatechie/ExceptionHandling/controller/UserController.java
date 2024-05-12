package com.ngash.javatechie.ExceptionHandling.controller;

import com.ngash.javatechie.ExceptionHandling.Advice.UserNotFoundException;
import com.ngash.javatechie.ExceptionHandling.dto.UserRequest;
import com.ngash.javatechie.ExceptionHandling.entity.User;
import com.ngash.javatechie.ExceptionHandling.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@Valid @RequestBody UserRequest userRequest){
        return new ResponseEntity<User>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.fetchAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/fetchOne/{id}")
    public ResponseEntity<User> findOneUser(@PathVariable("id") int id) throws UserNotFoundException {
        return new ResponseEntity<>(userService.fetchSingleUser(id), HttpStatus.OK);
    }

    @GetMapping("fetchByName/{name}")
    public List<User> findByName(@PathVariable("name") String name) throws UserNotFoundException {
        return userService.findByName(name);
    }
}







