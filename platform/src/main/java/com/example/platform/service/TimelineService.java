package com.example.platform.service;

import com.example.platform.model.Tweet;
import com.example.platform.model.User;

import java.util.List;

public interface TimelineService {
    List<Tweet> getTimeline(User user);
}
