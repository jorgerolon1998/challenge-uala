package com.example.platform.controller;

import com.example.platform.model.User;
import com.example.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{username}/follow")
    public void followUser(@PathVariable String username, @RequestParam String toFollow) {
        User follower = userService.findUserByUsername(username);
        User following = userService.findUserByUsername(toFollow);
        userService.followUser(follower, following);
    }
}
