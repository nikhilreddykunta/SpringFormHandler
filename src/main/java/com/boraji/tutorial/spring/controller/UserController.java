package com.boraji.tutorial.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boraji.tutorial.spring.model.User;

/**
 * @author imssbora
 */
@Controller
public class UserController {

   /*
    * Create new user object for empty from
    */
   
   @ModelAttribute("user")
   public User setUpUserForm() {
      return new User();
   }

   /*
    * Open new registration form
    */
   @GetMapping("/")
   public String registration() {
      
      return "registrationForm";
   }

   /*
    *  Save user object
    */
   @PostMapping("/saveUser")
   public String saveUser(@ModelAttribute("user") User user, Model model) {

      // Implement business logic to save user details into a database
      //.....

      System.out.println("Username : " + user.getUsername());
      System.out.println("Password : " + user.getPassword());
      System.out.println("Email : " + user.getEmail());

      model.addAttribute("message", "User saved successfully.");

      return "registrationSuccess";
   }
}
