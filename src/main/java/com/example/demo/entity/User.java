package com.example.demo.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {
   public Long getId(){
      return id;
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="user_id")
   private Long id;

   public String getUserName(){
      return user_name;
   }

   public void setUserName(String user_name){
      this.user_name = user_name;
   }

   @Column(name="user_name")
   private String user_name;
}
