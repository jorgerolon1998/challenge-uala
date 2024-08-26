package com.example.platform;

import com.example.platform.async.RabbitMQProducer;
import com.example.platform.model.Tweet;
import com.example.platform.model.User;
import com.example.platform.repository.TweetRepository;
import com.example.platform.service.impl.TweetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TweetServiceImplTest {

    @Mock
    private TweetRepository tweetRepository;

    @Mock
    private RabbitMQProducer rabbitMQProducer; // Mock del RabbitMQProducer

    @InjectMocks
    private TweetServiceImpl tweetService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTweet() {
        User user = new User();
        user.setUsername("testuser");

        Tweet tweet = new Tweet();
        tweet.setContent("Hello, world!");
        tweet.setUser(user);

        when(tweetRepository.save(any(Tweet.class))).thenReturn(tweet);

        Tweet createdTweet = tweetService.createTweet(user, "Hello, world!");

        assertEquals("Hello, world!", createdTweet.getContent());
        assertEquals("testuser", createdTweet.getUser().getUsername());

        verify(rabbitMQProducer, times(1)).sendMessage(anyString()); // Verifica que se llama al productor
    }
}