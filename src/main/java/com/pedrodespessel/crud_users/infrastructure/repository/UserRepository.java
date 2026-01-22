package com.pedrodespessel.crud_users.infrastructure.repository;

import com.pedrodespessel.crud_users.infrastructure.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
