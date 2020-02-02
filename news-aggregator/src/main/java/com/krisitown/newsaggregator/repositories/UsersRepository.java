package com.krisitown.newsaggregator.repositories;

import com.krisitown.newsaggregator.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, String> {
    User findFirstByEmail(String email);
}
