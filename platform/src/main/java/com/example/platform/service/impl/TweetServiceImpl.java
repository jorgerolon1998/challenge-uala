package com.example.platform.service.impl;

import com.example.platform.async.RabbitMQProducer;
import com.example.platform.model.Tweet;
import com.example.platform.model.User;
import com.example.platform.repository.TweetRepository;
import com.example.platform.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @Override
    public Tweet createTweet(User user, String content) {
        Tweet tweet = new Tweet();
        tweet.setUser(user);
        tweet.setContent(content);
        tweet.setTimestamp(LocalDateTime.now());
        tweetRepository.save(tweet);

        rabbitMQProducer.sendMessage("New tweet from " + user.getUsername() + ": " + content);

        return tweet;
    }
}
