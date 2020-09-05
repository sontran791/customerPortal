package com.java.customerportal.service;

import com.java.customerportal.exception.domain.EmailNotFoundException;
import com.java.customerportal.model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws Exception;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User addNewUser(String firstName, String lastName, String username,
                        String email, String role, boolean isNonLocked,
                        boolean isActive, MultipartFile profileImage) throws Exception;

    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername,
                        String newEmail, String role, boolean isNonLocked,
                        boolean isActive, MultipartFile profileImage) throws Exception;

    void deleteUser(String userId);

    void resetPassword(String email) throws EmailNotFoundException, MessagingException;

    User updateProfileImage(String username, MultipartFile profileImage) throws Exception;
}
