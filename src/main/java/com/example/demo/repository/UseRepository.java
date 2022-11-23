package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UseRepository extends JpaRepository<User, Long> {

   @Query("SElECT q FROM User q WHERE q.user_name LIKE %?1%")
   List<User> getContainingUser(String word);
   
}
