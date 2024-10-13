package com.jgji.selfassessment.domain.auth.presentation;

import com.jgji.selfassessment.domain.auth.presentation.dto.SignInRequest;
import com.jgji.selfassessment.domain.auth.presentation.dto.SignInResponse;
import com.jgji.selfassessment.global.config.security.token.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(params = "/auth")
@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/sign-in")
    public SignInResponse login(@RequestBody SignInRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.email(),
                        signInRequest.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = tokenProvider.generateToken(signInRequest.email());
        return new SignInResponse(jwtToken);
    }
}
