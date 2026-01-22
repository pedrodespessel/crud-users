package com.pedrodespessel.crud_users.business;

import com.pedrodespessel.crud_users.infrastructure.entitys.User;
import com.pedrodespessel.crud_users.infrastructure.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service

public class UserService {
     private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.saveAndFlush(user);
    }

    public User findUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email not found.")
        );
    }

    @Transactional
    public void deleteUserByEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void updateUserById (Integer id, User user) {
        User userEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found."));
        User userUpdated = User.builder()
                .email(user.getEmail() != null ? user.getEmail() :
                        userEntity.getEmail())
                .name(user.getName() != null ?
                        user.getName() : userEntity.getName())
                .id(userEntity.getId())
                .build();

        repository.saveAndFlush(userUpdated);

    }

}
