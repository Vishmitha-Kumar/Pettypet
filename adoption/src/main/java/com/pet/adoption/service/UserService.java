package com.pet.adoption.service;



import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pet.adoption.model.User;
import com.pet.adoption.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user) {
        Optional<User> userExists = userRepository.findByEmail(user.getEmail());
        if (userExists.isPresent())
            throw new IllegalArgumentException("Email already exist");
        else
        return userRepository.save(user);
    }










    public ResponseEntity<?> loginUser(String email, String password) {
        try {
            Optional<User> existingUser = userRepository.findByEmail(email);
            if (existingUser.isPresent()) {
                User user = existingUser.get();
                if (user.getPassword().equals(password)) {
                    return ResponseEntity.ok("Success");
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }


//    public String getUserByEmail(User user) {
//        boolean userExists = userRepository.existsByEmail(user.getEmail());
//        if (userExists) {
//            return "Login successful";
//        }
//        return "Invalid username/password";
//    }

//public String loginUser(User user) {
//    Optional<User> existingUserOptional = userRepository.findByEmail(user.getEmail());
//    if (existingUserOptional.isPresent()) {
//        User existingUser = existingUserOptional.get();
//        if (existingUser.getPassword().equals(user.getPassword())) {
//            return "Login successful";
//        } else {
//            return "Invalid password";
//        }
//    } else {
//        return "User not found";
//    }
//}
//public String loginUser(User user) {
//    Optional<User> existingUserOptional = userRepository.findByEmail(user.getEmail());
//    if (existingUserOptional.isPresent()) {
//        return "Login succesfull";
//    }
//    else
//        return "invalid username";
//
//}
//    public User updateUser(String email, User user) {
//        Optional<User> userExists = userRepository.findByEmail(email);
//        if (userExists.isPresent()) {
//            User existingUser = userExists.get();
//            existingUser.setUsername(user.getUsername());
//            existingUser.setPassword(user.getPassword());
//            existingUser.setPhone(user.getPhone());
//            existingUser.setAddress(user.getAddress());
//            return userRepository.save(existingUser);
//        }
//        return new User();
//    }
//    public String deleteUser(String email) {
//        boolean userExists = userRepository.existsByEmail(email);
//        if (userExists) {
//            userRepository.deleteByEmail(email);
//            return "User deleted successfully!";
//        }
//        return "Record not found with email id " + email;
//    }
//    public User updateUserBy(String email, User user) {
//        Optional<User> userExists = userRepository.findByEmail(email);
//        return userExists.map(existingUser -> {
//            Optional.ofNullable(user.getUsername()).ifPresent(existingUser::setUsername);
//            Optional.ofNullable(user.getPassword()).ifPresent(existingUser::setPassword);
//            Optional.ofNullable(user.getAddress()).ifPresent(existingUser::setAddress);
//            return userRepository.save(existingUser);
//        }).orElse(new User());
//    }


}