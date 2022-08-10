package com.stage.catalogue.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stage.catalogue.entity.Utilisateur;
import com.stage.catalogue.security.TokenType;
import com.stage.catalogue.security.util.JwtUtils;
import com.stage.catalogue.service.UtilisateurService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import org.springframework.http.MediaType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vincent
 */
@RestController
@RequestMapping("${apiPrefix}/tokens")
public class TokenController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private JwtUtils jwtUtils;

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Map<String, String> result = jwtUtils.getClaims(refresh_token);
                String username = result.get("username");
                TokenType type = TokenType.valueOf(result.get("type"));
                String access_token = "";
                if (type == TokenType.REFRESH) {
                    Utilisateur user = utilisateurService.findByUsername(username).orElse(new Utilisateur());
                    access_token = jwtUtils.createAccessToken(username, user.getRole());
                }
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }
}
