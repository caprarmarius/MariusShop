package com.mariushop.mariushop.controllers;

import com.mariushop.mariushop.dtos.UserDTO;
import com.mariushop.mariushop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO newUser) {
        return userService.save(newUser);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO updateUser(@PathVariable Integer id, @RequestBody UserDTO userToUpdate) {
        return userService.update(id, userToUpdate);
    }

    @PatchMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO postCart(@PathVariable String username, @RequestBody UserDTO userDTO) {
        return userService.postCart(username, userDTO);
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
