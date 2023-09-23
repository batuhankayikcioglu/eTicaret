package com.batdev.eticaret.app.ticaret.controller;

import com.batdev.eticaret.app.ticaret.dto.CreateUserRequest;
import com.batdev.eticaret.app.ticaret.dto.UpdateUserRequest;
import com.batdev.eticaret.app.ticaret.dto.UserDto;
import com.batdev.eticaret.app.ticaret.model.User;
import com.batdev.eticaret.app.ticaret.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id")Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest)); //201

    }
    @PutMapping("/{id} ")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest updateUserRequest){
        return ResponseEntity.ok(userService.updateUser(id,updateUserRequest));

    }
    /*@PatchMapping("/{id} ")
    public ResponseEntity<Void> deactiveUser(@PathVariable("id")Long id){
        userService.deactiveUser(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id} ")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


     */
}
