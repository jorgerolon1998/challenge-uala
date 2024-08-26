package com.example.platform.service;

import com.example.platform.model.User;

import java.util.List;

public interface UserService {
    User findUserByUsername(String username);
    void followUser(User follower, User following);
    List<User> findAllFollowing(User follower);
}
