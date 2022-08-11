package com.stage.catalogue.security;

import com.stage.catalogue.entity.Utilisateur;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author vincent
 */
public class CustomUserDetails extends Utilisateur implements UserDetails{
    
    public CustomUserDetails(Utilisateur utilisateur){
        setEmail(utilisateur.getEmail());
        setEnabled(utilisateur.isEnabled());
        setId(utilisateur.getId());
        setLocked(utilisateur.isLocked());
        setName(utilisateur.getName());
        setPassword(utilisateur.getPassword());
        setRole(utilisateur.getRole());
        setUsername(utilisateur.getUsername());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(getRole().toString());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
}
