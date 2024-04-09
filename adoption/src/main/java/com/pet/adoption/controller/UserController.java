package com.pet.adoption.controller;
import com.pet.adoption.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pet.adoption.model.User;
import com.pet.adoption.service.UserService;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository ur;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exist");
        }
    }

//    @PostMapping("/get")
//    public ResponseEntity<?> getUserByEmail(@RequestParam User user) {
//        try {
//            return new ResponseEntity<>(userService.getUserByEmail(user), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
//        }
//    }

//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody User user) {
//        try {
////            String result = userService.loginUser(user);
////            return ResponseEntity.ok(result);
//            return new ResponseEntity<>(userService.loginUser(user), HttpStatus.OK);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Email or Password");
//        }
//    }








//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody User user) {
//        Optional<User> existingUser=ur.findByEmail(user.getEmail());
//       if(existingUser.isPresent())
//           return ResponseEntity.ok("success");
//       else
//           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed");
//    }










    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            return userService.loginUser(user.getEmail(), user.getPassword());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }



//    @PutMapping("/update/{email}")
//    public ResponseEntity<?> updateUser(@PathVariable String email, @RequestBody User user) {
//        try {
//            return new ResponseEntity<>(userService.updateUser(email, user), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
//        }
//    }

//    @DeleteMapping("/delete/{email}")
//    public ResponseEntity<?> deleteUser(@PathVariable String email) {
//        try {
//            return new ResponseEntity<>(userService.deleteUser(email), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
//        }
//    }

//    @PatchMapping("/patchUpdate/{email}")
//    public ResponseEntity<?> updateUserBy(@PathVariable String email, @RequestBody User user) {
//        try {
//            return new ResponseEntity<>(userService.updateUserBy(email, user), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
//        }
//    }

}