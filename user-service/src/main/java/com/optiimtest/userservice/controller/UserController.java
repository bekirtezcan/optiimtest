package com.optiimtest.userservice.controller;

import com.optiimtest.userservice.model.User;
import com.optiimtest.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
@RestController
@RequestMapping("/")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Mono<User> saveUser(@RequestBody User user) {
        return userService.insert(user);
    }

    @GetMapping(value = "/{id}")
    public Mono<User> getUser(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @GetMapping(value = "/list")
    public Flux<User> getUsers() {
        return userService.findAll();
    }
}
