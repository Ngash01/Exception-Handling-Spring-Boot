package com.ngash.javatechie.ExceptionHandling.service;

import com.ngash.javatechie.ExceptionHandling.Advice.UserNotFoundException;
import com.ngash.javatechie.ExceptionHandling.dto.UserRequest;
import com.ngash.javatechie.ExceptionHandling.entity.User;
import com.ngash.javatechie.ExceptionHandling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    Save user to the database
    public User saveUser(UserRequest userRequest){
//        User user =User.build(0,userRequest.getName(),userRequest.getEmail(),userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());

        User user = User.builder().userId(0).name(userRequest.getName()).email(userRequest.getEmail()).mobile(userRequest.getMobile())
                .gender(userRequest.getGender()).age(userRequest.getAge()).nationality(userRequest.getNationality()).build();

//   This code is taking user data from a UserRequest, creating a User object with that data, and then saving that User object to the database

        return userRepository.save(user);
    }

//    fetch user from the database
    public List<User> fetchAllUsers(){
        return userRepository.findAll();
    }

//    fetch a single user
    public User fetchSingleUser(int id) throws UserNotFoundException {
        User user =  userRepository.findByUserId(id);
        if(user!=null){
            return user;
        }

        throw new UserNotFoundException("User with id " + id + " was not found");
    }

//    find by Name
    public List<User> findByName(String name) throws UserNotFoundException {

        List<User> users =  userRepository.findByNameIgnoreCase(name);
        if(!users.isEmpty()){
            return users;
        }
        throw new UserNotFoundException("No users named " + name + " found!");
    }
}

