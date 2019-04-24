package com.yangrd.ipress.config.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * JWTLoginFilter
 *
 * @author yangrd
 * @date 2019/04/24
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    private JwtTokenProvider jwtTokenProvider;

    public JwtLoginFilter(String url, AuthenticationManager authManager, JwtTokenProvider jwtTokenProvider) {
        super(new AntPathRequestMatcher(url,"POST"));
        setAuthenticationManager(authManager);
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
        UserLoginDTO userLoginDTO = new ObjectMapper()
                .readValue(req.getInputStream(), UserLoginDTO.class);
        try {
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userLoginDTO.getUsername(),
                            userLoginDTO.getPassword()
                    )
            );
        }catch (BadCredentialsException badCredentialsException){
            throw  badCredentialsException;
        }

    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
        PrintWriter writer = res.getWriter();
        writer.print(jwtTokenProvider.createToken(auth.getName(),auth.getAuthorities()));
        writer.flush();
        writer.close();
    }
}