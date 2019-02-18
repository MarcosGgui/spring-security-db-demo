package com.marcos.spring.security.springsecuritydbdemo.service;

import com.marcos.spring.security.springsecuritydbdemo.model.CustomUserDetails;
import com.marcos.spring.security.springsecuritydbdemo.model.User;
import com.marcos.spring.security.springsecuritydbdemo.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optionalUser = userRepository.findByName(username);
    optionalUser.orElseThrow(() -> new UsernameNotFoundException("UserName Not Found"));
    return optionalUser.map(CustomUserDetails::new).get();
  }
}
