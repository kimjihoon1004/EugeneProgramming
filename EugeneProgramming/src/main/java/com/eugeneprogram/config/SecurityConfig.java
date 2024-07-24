package com.eugeneprogram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.eugeneprogram.security.CustomAuthenticationProvider;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {
        http
            .authorizeHttpRequests((authz) -> authz
                    .requestMatchers(
                            new AntPathRequestMatcher("/"),
                            new AntPathRequestMatcher("/selectTC.do"),
                            new AntPathRequestMatcher("/testPage"),
                            new AntPathRequestMatcher("/tc/test.html"),
                            new AntPathRequestMatcher("/visa.do"),
                            new AntPathRequestMatcher("/stRetrieve.html")
                    ).permitAll()
                    .anyRequest().authenticated())
            .httpBasic(withDefaults());
        return http.build();
    }
    
    
}
