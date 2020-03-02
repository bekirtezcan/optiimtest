package com.optiimtest.userservice.controller;

import com.optiimtest.userservice.model.User;
import com.optiimtest.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{id}")
    public Mono<User> getUser(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @GetMapping(value = "/users")
    public Flux<User> getUsers() {
        return userService.findAll();
    }
}
