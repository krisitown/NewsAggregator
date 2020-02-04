package com.krisitown.newsaggregator.controller;

import com.krisitown.newsaggregator.dto.LoginRequestBody;
import com.krisitown.newsaggregator.dto.UserBodyResponse;
import com.krisitown.newsaggregator.models.User;
import com.krisitown.newsaggregator.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public UserBodyResponse register(@RequestBody @Validated User userBody) throws Exception{
        User createdUser = userService.createUser(userBody);
        if(createdUser != null){
            return transformUserToResponse(createdUser);
        }
        throw new Exception("User could not be created!");
    }

    @GetMapping("/{userId}")
    public UserBodyResponse getUser(@PathVariable String userId){
        return transformUserToResponse(userService.getUser(userId));
    }

    @PostMapping("/auth")
    public UserBodyResponse authenticate(@RequestBody LoginRequestBody loginBody) throws Exception {
        return transformUserToResponse(userService.authenticateUser(loginBody.getEmail(), loginBody.getPassword()));
    }

    @DeleteMapping("/deleteUser")
    public UserBodyResponse deleteUser(@RequestParam String token){
        return transformUserToResponse(userService.deleteUser(token));
    }

    private UserBodyResponse transformUserToResponse(User userBody){
        UserBodyResponse response = new UserBodyResponse();
        response.setEmail(userBody.getEmail());
        response.setName(userBody.getName());
        response.setToken(userBody.getToken());
        return response;
    }
}
