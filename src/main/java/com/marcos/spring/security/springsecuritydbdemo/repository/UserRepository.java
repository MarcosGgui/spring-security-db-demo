package com.marcos.spring.security.springsecuritydbdemo.repository;

import com.marcos.spring.security.springsecuritydbdemo.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

  Optional<User> findByName(String username);
}
