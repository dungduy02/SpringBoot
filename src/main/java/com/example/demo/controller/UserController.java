package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UseRepository;
import com.example.demo.service.IUserService;

@RestController
public class UserController {
   @Autowired
   private IUserService userService;
   @Autowired
   private  UseRepository useRepository;

   @GetMapping("/user")
   public List<User> getUser(@RequestParam("search") Optional<String> searchParam){
      return searchParam.map(param -> userService.getUserAll(param))
      .orElse(useRepository.findAll());   
      // return searchParam.map(param -> useRepository.getContainingUser(param))
      //    .orElse(useRepository.findAll());
   }

   @GetMapping("/user/{id}")
   public ResponseEntity<String> readUse(@PathVariable("id") Long id){
      return ResponseEntity.of(useRepository.findById(id).map(User::getUserName));
   }

   @PostMapping("/user")
   public User addUser(@RequestBody String user){
      User newUser = new User();
      newUser.setUserName(user);
      return useRepository.save(newUser);
   }

   @DeleteMapping(value = "userde/{id}")
   private void deleteUser(@PathVariable("id") Long id){
      useRepository.deleteById(id);
   }

   
}
