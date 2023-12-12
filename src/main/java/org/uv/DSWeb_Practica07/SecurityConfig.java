/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWeb_Practica07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeHttpRequests().mvcMatchers("/api/User").permitAll()
                .anyRequest().authenticated().and().httpBasic();
//                .authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();

        return http.build();
    }
    
     @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder ();

        return passwordEncoder;
    }
    
     @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user1= org.springframework.security.core.userdetails.User
                .withUsername("zuri")
                .password(passwordEncoder().encode("123"))
                .roles("USER")
                .build();
        
        UserDetails user2= org.springframework.security.core.userdetails.User
                .withUsername("pepe")
                .password(passwordEncoder().encode("123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
}
