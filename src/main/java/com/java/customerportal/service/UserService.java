package com.java.customerportal.service;

import com.java.customerportal.model.User;

import java.util.List;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws Exception;

    List<User> getUser();

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
