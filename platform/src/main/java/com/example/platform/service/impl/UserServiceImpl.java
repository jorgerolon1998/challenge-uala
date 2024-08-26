package com.example.platform.service.impl;

import com.example.platform.model.Follow;
import com.example.platform.model.User;
import com.example.platform.repository.FollowRepository;
import com.example.platform.repository.UserRepository;
import com.example.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowRepository followRepository;

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void followUser(User follower, User following) {
        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);
        followRepository.save(follow);
    }

    @Override
    public List<User> findAllFollowing(User follower) {
        return followRepository.findAllByFollower(follower).stream()
                .map(Follow::getFollowing)
                .toList();
    }
}
