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
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author vincent
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    private final UserDetailsService userDetailsService;
    
    private final JwtUtils jwtUtils;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {  
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean(), jwtUtils);
        customAuthenticationFilter.setFilterProcessesUrl("/api/users/login");
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/api/user/login/**", "api/tokens/**", "/static/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/utilisateurs").hasAuthority(Role.ADMIN.toString());
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/utilisateurs").hasAuthority(Role.ADMIN.toString());
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(jwtUtils), UsernamePasswordAuthenticationFilter.class);
       
        //super.configure(http);
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
