package com.marcos.spring.security.springsecuritydbdemo.config;

import com.marcos.spring.security.springsecuritydbdemo.repository.UserRepository;
import com.marcos.spring.security.springsecuritydbdemo.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

  @Autowired
  private CustomUserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable();
      http.authorizeRequests()
          .antMatchers("**/secured/**").authenticated()
          .anyRequest().permitAll()
          .and()
          .formLogin().permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
        .passwordEncoder(getPasswordEncoder()
        );
  }

  private PasswordEncoder getPasswordEncoder() {
    return new PasswordEncoder(){
      @Override
      public String encode(CharSequence charSequence) {
        return null;
      }

      @Override
      public boolean matches(CharSequence charSequence, String s) {
        return false;
      }
    };
  }
}
