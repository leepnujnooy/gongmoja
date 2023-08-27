package com.est.gongmoja.oauth2;

import com.est.gongmoja.jwt.JwtTokenUtil;
import com.est.gongmoja.repository.RefreshTokenRepository;
import com.est.gongmoja.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final RefreshTokenRepository refreshTokenRepository;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //OAuth 2 인증에 성공했을 경우 여기로 들어온다
        log.info("success 안에 들어옴");
        String targetUrl = determineTargetUrl(request, response, authentication);




        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }



}
