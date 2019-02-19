package com.marcos.spring.security.springsecuritydbdemo.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource{

  @GetMapping("/all")
  public String hello() {
    return "Hello Welcome";
  }

  @PreAuthorize("hasAnyAuthority('ADMIN')")
  @GetMapping("/secured")
  public String securedHello() {
    return "Secured Hello";
  }
}
