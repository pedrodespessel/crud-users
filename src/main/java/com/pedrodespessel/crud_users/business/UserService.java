package com.pedrodespessel.crud_users.business;

import com.pedrodespessel.crud_users.infrastructure.entitys.User;
import com.pedrodespessel.crud_users.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service

public class UserService {
     private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user){
        repository.saveAndFlush(user);
    }
}
