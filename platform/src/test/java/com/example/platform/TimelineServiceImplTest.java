package com.example.platform;

import com.example.platform.model.Tweet;
import com.example.platform.model.User;
import com.example.platform.repository.TweetRepository;
import com.example.platform.service.UserService;
import com.example.platform.service.impl.TimelineServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

public class TimelineServiceImplTest {

    @Mock
    private TweetRepository tweetRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private TimelineServiceImpl timelineService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTimeline() {
        User user = new User();
        user.setUsername("testuser");

        List<User> following = new ArrayList<>();
        following.add(user);

        Tweet tweet = new Tweet();
        tweet.setContent("Hello, world!");
        tweet.setUser(user);

        List<Tweet> tweets = new ArrayList<>();
        tweets.add(tweet);

        when(userService.findAllFollowing(user)).thenReturn(following);
        when(tweetRepository.findAllByUserInOrderByTimestampDesc(anyList())).thenReturn(tweets);

        List<Tweet> timeline = timelineService.getTimeline(user);

        assertEquals(1, timeline.size());
        assertEquals("Hello, world!", timeline.get(0).getContent());
    }
}
