package com.spring.security.jwt.two.controller;

import com.spring.security.jwt.two.entity.User;
import com.spring.security.jwt.two.serivice.PublicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/public")
@Tag(name = "Public API")
@RequiredArgsConstructor
public class PublicController {

    private final PublicService publicService;

    @GetMapping("/users")
    public ResponseEntity<Object> findAllUsers(){
        List<User> allUsers = publicService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<Object> findUserById(@PathVariable Long userId){
        User user = publicService.getUserById(userId);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable Long userId,@RequestBody User user){
        User user1= publicService.updateUser(userId, user);
        if(user1 == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @PatchMapping("/users/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable Long userId, @RequestBody Map<String, Object> properties){
        User user1= publicService.updateUserDetails(userId, properties);
        if(user1 == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@RequestBody User user){
        User user1= publicService.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long userId){
       try{
        this.publicService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }
}
