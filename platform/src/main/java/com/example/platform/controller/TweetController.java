package com.example.platform.controller;

import com.example.platform.model.Tweet;
import com.example.platform.model.User;
import com.example.platform.service.TweetService;
import com.example.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Tweet createTweet(@RequestParam String username, @RequestBody String content) {
        User user = userService.findUserByUsername(username);
        return tweetService.createTweet(user, content);
    }
}

