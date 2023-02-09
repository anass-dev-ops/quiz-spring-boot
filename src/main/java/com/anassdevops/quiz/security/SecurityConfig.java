package com.anassdevops.quiz.security;

import com.anassdevops.quiz.security.entity.AppUser;
import com.anassdevops.quiz.security.filter.JwtAuthenticationFilter;
import com.anassdevops.quiz.security.filter.JwtAuthorizationFilter;
import com.anassdevops.quiz.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthService authService;

    @Autowired
    SecurityConfig(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                AppUser appUser = authService.loadUserByUsername(username);
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                appUser.getRoles().forEach(appRole -> {
                    authorities.add(new SimpleGrantedAuthority(appRole.getName()));
                });
                return new User(username, appUser.getPassword(), authorities );
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // http.formLogin();
        http.csrf().disable();
        // http.cors().disable();
        http.headers().frameOptions().disable();

        // http.authorizeHttpRequests().antMatchers("/h2-console/**", "/api/questions/quizzes/**").permitAll();
        // http.authorizeHttpRequests().antMatchers("/refreshToken/**").permitAll();
        // http.authorizeHttpRequests().antMatchers("/api/categories").permitAll();
        // http.authorizeHttpRequests().antMatchers("/api/quizzes").permitAll();
        // http.authorizeHttpRequests().antMatchers().permitAll();
         http.authorizeHttpRequests().antMatchers(HttpMethod.POST,
                 "/api/categories/**",
                 "/api/quizzes/**",
                 "/api/questions/**"
         ).hasAuthority("USER");
        http.authorizeHttpRequests().anyRequest().permitAll();

        http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
