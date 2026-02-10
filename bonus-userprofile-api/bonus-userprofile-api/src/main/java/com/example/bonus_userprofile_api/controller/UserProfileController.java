package com.example.bonus_userprofile_api.controller;

import com.example.bonus_userprofile_api.model.ApiResponse;
import com.example.bonus_userprofile_api.model.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private List<UserProfile> users = new ArrayList<>();

    public UserProfileController() {
        users.add(new UserProfile(1L, "john_doe", "john@example.com",
                "John Doe", 25, "USA", "Software developer", true));
        users.add(new UserProfile(2L, "alice", "alice@example.com",
                "Alice Smith", 30, "UK", "Designer", true));
        users.add(new UserProfile(3L, "mark", "mark@example.com",
                "Mark Lee", 40, "Canada", "Manager", false));
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<UserProfile>> createUser(@RequestBody UserProfile user) {
        users.add(user);
        return new ResponseEntity<>(
                new ApiResponse<>(true, "User profile created successfully", user),
                HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ApiResponse<List<UserProfile>> getAllUsers() {
        return new ApiResponse<>(true, "Users retrieved", users);
    }

    // READ BY ID
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> getUserById(@PathVariable Long userId) {
        return users.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst()
                .map(u -> ResponseEntity.ok(
                        new ApiResponse<>(true, "User found", u)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "User not found", null)));
    }

    // UPDATE
    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> updateUser(
            @PathVariable Long userId,
            @RequestBody UserProfile updatedUser) {

        for (UserProfile u : users) {
            if (u.getUserId().equals(userId)) {
                u.setUsername(updatedUser.getUsername());
                u.setEmail(updatedUser.getEmail());
                u.setFullName(updatedUser.getFullName());
                u.setAge(updatedUser.getAge());
                u.setCountry(updatedUser.getCountry());
                u.setBio(updatedUser.getBio());
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User updated successfully", u));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "User not found", null));
    }

    // DELETE
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long userId) {
        boolean removed = users.removeIf(u -> u.getUserId().equals(userId));
        if (removed) {
            return ResponseEntity.ok(
                    new ApiResponse<>(true, "User deleted successfully", null));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "User not found", null));
    }

    // SEARCH BY USERNAME
    @GetMapping("/search/username")
    public ApiResponse<List<UserProfile>> searchByUsername(@RequestParam String username) {
        return new ApiResponse<>(
                true,
                "Search result",
                users.stream()
                        .filter(u -> u.getUsername().toLowerCase().contains(username.toLowerCase()))
                        .collect(Collectors.toList()));
    }

    // SEARCH BY COUNTRY
    @GetMapping("/search/country/{country}")
    public ApiResponse<List<UserProfile>> searchByCountry(@PathVariable String country) {
        return new ApiResponse<>(
                true,
                "Users by country",
                users.stream()
                        .filter(u -> u.getCountry().equalsIgnoreCase(country))
                        .collect(Collectors.toList()));
    }

    // SEARCH BY AGE RANGE
    @GetMapping("/search/age")
    public ApiResponse<List<UserProfile>> searchByAgeRange(
            @RequestParam int min,
            @RequestParam int max) {

        return new ApiResponse<>(
                true,
                "Users by age range",
                users.stream()
                        .filter(u -> u.getAge() >= min && u.getAge() <= max)
                        .collect(Collectors.toList()));
    }

    // ACTIVATE / DEACTIVATE
    @PatchMapping("/{userId}/active")
    public ResponseEntity<ApiResponse<UserProfile>> toggleActive(@PathVariable Long userId) {
        for (UserProfile u : users) {
            if (u.getUserId().equals(userId)) {
                u.setActive(!u.isActive());
                return ResponseEntity.ok(
                        new ApiResponse<>(true, "User status updated", u));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "User not found", null));
    }
}
