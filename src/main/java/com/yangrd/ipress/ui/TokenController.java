package com.yangrd.ipress.ui;

import com.yangrd.ipress.config.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * TokenController
 *
 * @author yangrd
 * @date 2019/04/24
 */
@AllArgsConstructor

@RestController
@RequestMapping("/token")
public class TokenController {

    private UserService userService;

    @PostMapping("/signin")
    public String login(String username,String password){
        return userService.signin(username, password);
    }

    @GetMapping("/me")
    public UserDetails whoami(Principal principal){
        return (UserDetails)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
    }

    @GetMapping("/refresh")
    public String refresh(HttpServletRequest request){
        return userService.refresh(request.getRemoteUser());
    }

}
