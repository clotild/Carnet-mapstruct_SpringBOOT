package com.example.tpcarnet.security;

import com.example.tpcarnet.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    //private static final String
    @Bean
    UserDetailsService customUserDetailsService() {
        return new UserDetailsServiceImp();
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(customUserDetailsService());
        return provider;
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                //.authorizeHttpRequests(requests -> {})
                .authorizeHttpRequests( requests -> {
                    requests
                            .requestMatchers("/").permitAll()
                            .requestMatchers("/users/**").permitAll()
                            .anyRequest().authenticated();
                })
                .formLogin(form -> {
                    form
                            .loginPage("/login") //Indique que je souhaite utiliser mon propre thymeleaf(formulaire)
                            .usernameParameter("email") // <input name = "email">
                            .passwordParameter("password") // <input name = "password">
                            .permitAll()
                            .defaultSuccessUrl("/profile");
                })
                .logout(logout -> {
                    logout.logoutUrl("/logout");
                })
                .build();
    }
}
