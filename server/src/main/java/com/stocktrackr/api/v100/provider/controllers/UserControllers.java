package com.stocktrackr.api.v100.provider.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserControllers {

    @PostMapping(path = "/register")
    public void registerUser(@RequestBody String name, @RequestBody String emailID, @RequestBody String dateOfBirth) {}

    @PostMapping(path = "/login")
    public void loginUser(@RequestBody String emailID) {};

}
