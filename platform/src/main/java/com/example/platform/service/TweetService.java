package com.example.platform.service;

import com.example.platform.model.Tweet;
import com.example.platform.model.User;

public interface TweetService {
    Tweet createTweet(User user, String content);
}
