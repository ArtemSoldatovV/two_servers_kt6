package com.example.UserService.Controller;

import com.example.UserService.Domain.User;
import com.example.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(order -> ResponseEntity.ok(order))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public User createUser(@RequestBody User order) {
        return userRepository.save(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateOrder(@PathVariable Long id, @RequestBody User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setId(userDetails.getId());
                    user.setName(userDetails.getName());
                    user.setPassword(userDetails.getPassword());
                    user.setDate_added(userDetails.getDate_added());
                    user.setContact_information(userDetails.getContact_information());
                    User updatedOrder = userRepository.save(user);
                    return ResponseEntity.ok(updatedOrder);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
