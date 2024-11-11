package com.java.crud.controller;

import com.java.crud.dto.UserData;
import com.java.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserData> createUser(@RequestBody UserData userData) {
        UserData createdUser = userService.saveUser(userData);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserData> getUser(@PathVariable("userId") Long userId) {
        UserData userData = userService.getUserById(userId);
        return new ResponseEntity<>(userData, HttpStatus.OK);
    }

    @PutMapping("/user/update/{userId}")
    public ResponseEntity<UserData> updateUser(@PathVariable Long userId, @RequestBody UserData userData) throws Exception {
        UserData updatedData = userService.updateUser(userId, userData);
        return new ResponseEntity<>(updatedData, HttpStatus.OK);
    }

    @DeleteMapping("/user/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) throws Exception {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
