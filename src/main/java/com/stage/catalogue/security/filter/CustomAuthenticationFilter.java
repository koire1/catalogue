package com.stage.catalogue.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stage.catalogue.entity.Role;
import com.stage.catalogue.security.util.JwtUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author vincent
 */
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = "";
        String password = "";
        if(request.getContentType().equals(APPLICATION_JSON_VALUE)){
            try {
                Map<String, String> model = new ObjectMapper().readValue(request.getInputStream(), HashMap.class);
                username =  (String)model.getOrDefault("username", "");
                password = (String)model.getOrDefault("password", "");
            } catch (IOException ex) {
                Logger.getLogger(CustomAuthenticationFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            username = request.getParameter("username");
            password = request.getParameter("password");
        }
        log.info("Username is: {}", username); 
        log.info("Password is: {}", password);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        UserDetails user = (UserDetails)authentication.getPrincipal();
        String name = ((SimpleGrantedAuthority)user.getAuthorities().toArray()[0]).getAuthority();
        String access_token = jwtUtils.createAccessToken(user.getUsername(), Role.valueOf(name));
        String refresh_token = jwtUtils.createRefreshToken(user.getUsername());
        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", access_token);
        tokens.put("refresh_token", refresh_token);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }
}