package com.example.platform.controller;

import com.example.platform.model.Tweet;
import com.example.platform.model.User;
import com.example.platform.service.TimelineService;
import com.example.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeline")
public class TimelineController {

    @Autowired
    private TimelineService timelineService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Tweet> getTimeline(@RequestParam String username) {
        User user = userService.findUserByUsername(username);
        return timelineService.getTimeline(user);
    }
}

