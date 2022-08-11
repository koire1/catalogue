package com.stage.catalogue.security;

import com.stage.catalogue.entity.Role;
import com.stage.catalogue.security.filter.CustomAuthenticationFilter;
import com.stage.catalogue.security.filter.CustomAuthorizationFilter;
import com.stage.catalogue.security.util.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author vincent
 */
@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    //private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

    private final AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager(), jwtUtils);
        customAuthenticationFilter.setFilterProcessesUrl("/api/users/login");
        http.csrf().disable();
        http.authorizeRequests((auth) -> auth
                .antMatchers("/api/user/login/**", "api/tokens/**", "/static/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/utilisateurs").hasAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/api/utilisateurs").hasAuthority(Role.ADMIN.toString())
                .anyRequest().authenticated()
        );
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(jwtUtils), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
