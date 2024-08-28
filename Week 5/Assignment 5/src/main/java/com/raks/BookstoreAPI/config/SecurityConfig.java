package com.raks.BookstoreAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService myUserDetailsService;
    private final com.raks.BookstoreAPI.security.JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(UserDetailsService myUserDetailsService, com.raks.BookstoreAPI.security.JwtRequestFilter jwtRequestFilter) {
        this.myUserDetailsService = myUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/authenticate").permitAll() // Allow access to the authentication endpoint
                .anyRequest().authenticated() // All other endpoints require authentication
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session management
            )
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT filter

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        @SuppressWarnings("unchecked")
		AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(
            (ObjectPostProcessor<Object>) http.getSharedObject(AuthenticationConfiguration.class).getAuthenticationManager()
        );
        authenticationManagerBuilder.userDetailsService(myUserDetailsService)
                                     .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}



