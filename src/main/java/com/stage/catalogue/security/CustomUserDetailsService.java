package com.stage.catalogue.security;

import com.stage.catalogue.dao.UtilisateurDao;
import com.stage.catalogue.entity.Utilisateur;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author vincent
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UtilisateurDao UtilisateurDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Utilisateur> oUser =  UtilisateurDao.findByUsername(username);
        if(!oUser.isPresent()){
            throw new UsernameNotFoundException(String.format("User with username %s not found", username));
        }
        return new CustomUserDetails(oUser.get());
    }
    
}
