package com.java.customerportal.service;

import com.java.customerportal.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws Exception;

    List<User> getUser();

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User addNewUser(String firstName, String lastName, String username,
                        String email, String role, boolean isNonLocked,
                        boolean isActive, MultipartFile profileImage);

    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername,
                        String newMail, String role, boolean isNonLocked,
                        boolean isActive, MultipartFile profileImage);
}
