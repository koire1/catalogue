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
        customAuthenticationFilter.setFilterProcessesUrl("/api/utilisateurs/login");
        http.csrf().disable();
        http.authorizeRequests((auth) -> auth
                .antMatchers("/api/utilisateurs/login/**", "api/tokens/**", "/static/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/utilisateurs").hasAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/api/utilisateurs").hasAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.PUT, "/api/utilisateurs").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.DELETE, "/api/utilisateurs").hasAuthority(Role.ADMIN.toString())
                
                .antMatchers(HttpMethod.GET, "/api/auteurs/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.POST, "/api/auteurs/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.PUT, "/api/auteurs/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.DELETE, "/api/auteurs/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                
                .antMatchers(HttpMethod.GET, "/api/livres/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.POST, "/api/livres/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.PUT, "/api/livres/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.DELETE, "/api/livres/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                
                
                .antMatchers(HttpMethod.GET, "/api/categories/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.POST, "/api/categories/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.PUT, "/api/categories/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.DELETE, "/api/categories/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                
                
                .antMatchers(HttpMethod.GET, "/api/memoires/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.POST, "/api/memoires/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.PUT, "/api/memoires/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.DELETE, "/api/memoires/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                
                .antMatchers(HttpMethod.GET, "/api/diplomes/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.POST, "/api/diplomes/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.PUT, "/api/diplomes/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.DELETE, "/api/diplomes/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                
                .antMatchers(HttpMethod.GET, "/api/departements/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.POST, "/api/departements/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.PUT, "/api/departements/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.DELETE, "/api/departements/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                
                .antMatchers(HttpMethod.GET, "/api/specialites/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.POST, "/api/specialites/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.PUT, "/api/specialites/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.DELETE, "/api/specialites/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                
                .antMatchers(HttpMethod.GET, "/api/etudiants/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.POST, "/api/etudiants/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.PUT, "/api/etudiants/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.DELETE, "/api/etudiants/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER.toString())
                
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
