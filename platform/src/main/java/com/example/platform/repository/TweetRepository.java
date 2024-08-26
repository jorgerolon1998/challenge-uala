package com.example.platform.repository;

import com.example.platform.model.Tweet;
import com.example.platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findAllByUserInOrderByTimestampDesc(List<User> users);
}
