package com.project.postcredit.controller;

import com.project.postcredit.model.LoginReq;
import com.project.postcredit.model.UserData;
import com.project.postcredit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginReq loginReq) {
        return userService.getLoginAuth(loginReq);
    }

    @PostMapping("signin")
    public ResponseEntity<String> signin(@RequestBody UserData userData) {
        return userService.signUp(userData);
    }


}
