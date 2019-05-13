package com.yangrd.ipress.application;

import com.yangrd.ipress.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * CustomUserDetailsService
 *
 * @author yangrd
 * @date 2019/05/13
 */
@AllArgsConstructor

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByUsername(username).orElseThrow(()->new UsernameNotFoundException("["+username+"]用户没有发现"));
    }
}
