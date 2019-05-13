package com.yangrd.ipress.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * User
 *
 * @author yangrd
 * @date 2019/05/13
 */
@AllArgsConstructor
@Getter
@Setter

@Entity
public class User extends AbstractPersistable<Long> implements UserDetails {

    @Column(unique = true)
    private String username;

    private String nickname;

    private String password;

    private String roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(roles.split(",")).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
