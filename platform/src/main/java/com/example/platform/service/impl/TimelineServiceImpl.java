package com.example.platform.service.impl;

import com.example.platform.model.Tweet;
import com.example.platform.model.User;
import com.example.platform.repository.TweetRepository;
import com.example.platform.service.TimelineService;
import com.example.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimelineServiceImpl implements TimelineService {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserService userService;

    @Override
    @Cacheable(value = "timelineCache", key = "#user.id")
    public List<Tweet> getTimeline(User user) {
        List<User> following = new ArrayList<>(userService.findAllFollowing(user));
        following.add(user);
        return tweetRepository.findAllByUserInOrderByTimestampDesc(following);
    }
}
