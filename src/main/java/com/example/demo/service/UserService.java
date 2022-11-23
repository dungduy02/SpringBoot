package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UseRepository;

@Service
public class UserService implements IUserService{

   // @Autowired
   private UseRepository useRepository;
   @Override
   public List<User> getUserAll(String search) {
      return useRepository.getContainingUser(search);
      
   }
   
}
