package com.example.platform;

import com.example.platform.model.Follow;
import com.example.platform.model.User;
import com.example.platform.repository.FollowRepository;
import com.example.platform.repository.UserRepository;
import com.example.platform.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private FollowRepository followRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindUserByUsername() {
        User user = new User();
        user.setUsername("testuser");

        when(userRepository.findByUsername(anyString())).thenReturn(user);

        User foundUser = userService.findUserByUsername("testuser");

        assertEquals("testuser", foundUser.getUsername());
    }

    @Test
    public void testFollowUser() {
        User user1 = new User();
        user1.setUsername("user1");

        User user2 = new User();
        user2.setUsername("user2");

        Follow follow = new Follow();
        follow.setFollower(user1);
        follow.setFollowing(user2);

        when(followRepository.save(any(Follow.class))).thenReturn(follow);
        when(followRepository.findAllByFollower(user1)).thenReturn(List.of(follow));

        userService.followUser(user1, user2);

        List<User> following = userService.findAllFollowing(user1);

        assertEquals(1, following.size());
        assertEquals("user2", following.get(0).getUsername());
    }

}