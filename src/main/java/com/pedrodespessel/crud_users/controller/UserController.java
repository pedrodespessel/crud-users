package com.pedrodespessel.crud_users.controller;

import com.pedrodespessel.crud_users.business.UserService;
import com.pedrodespessel.crud_users.infrastructure.entitys.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor // Using Lombok here to explore more features.
public class UserController {

    private final UserService userService;

    @PostMapping// Not best practice, but used here for study purposes (DTO would be preferable).
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> findUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserByEmail(@RequestParam String email) {
        userService.deleteUserByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestParam Integer id,
                                           @RequestBody User user) {
        userService.updateUserById(id, user);
        return ResponseEntity.ok().build();
    }
}
