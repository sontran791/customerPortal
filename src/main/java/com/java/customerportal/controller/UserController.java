package com.java.customerportal.controller;


import com.java.customerportal.exception.domain.EmailExistException;
import com.java.customerportal.exception.domain.ExceptionHandling;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = { "/user", "/" })
public class UserController extends ExceptionHandling {

    @GetMapping("/home")
    public String showUser() throws EmailExistException{
//        return "Application works!!!";
        throw new EmailExistException("This email address is already taken");
    }
}
