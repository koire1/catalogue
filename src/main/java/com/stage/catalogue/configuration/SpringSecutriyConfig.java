package com.stage.catalogue.configuration;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
/**
 *
 * @author cellule
 */
@Component
@EnableWebSecurity
public class SpringSecutriyConfig extends WebSecurityConfigurerAdapter{
    
     private static final String[] AUTH_WHITELIST = {
            "/api/users/authenticate",
            "/api/users/authenticateToken",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };
  
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.GET).permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.POST).permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.PUT).permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.PATCH).permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.DELETE).permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.HEAD).permitAll()
                .anyRequest().permitAll();
    }
    
    @Bean
        CorsConfigurationSource corsConfigurationSource() {
            final CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList(""));
            configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
            configuration.setAllowCredentials(true);
            configuration.setAllowedHeaders(Arrays.asList("*"));
            configuration.setExposedHeaders(Arrays.asList("X-Auth-Token", "Authorization", "Access-Control-Allow-Origin",
            "Access-Control-Allow-Credentials"));
            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
    }
}