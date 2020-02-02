package com.krisitown.newsaggregator.services.interfaces;

import com.krisitown.newsaggregator.models.User;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    User deleteUser(String token);
    User authenticateUser(String email, String password) throws Exception;
    User getUser(String token);
}
