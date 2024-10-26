package com.jgji.selfassessment.domain.auth.presentation;

import com.jgji.selfassessment.domain.auth.application.AuthenticationService;
import com.jgji.selfassessment.domain.auth.presentation.dto.SignInRequest;
import com.jgji.selfassessment.domain.auth.presentation.dto.SignInResponse;
import com.jgji.selfassessment.global.config.security.token.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
@RestController
public class AuthController {

    private final TokenProvider tokenProvider;
    private final AuthenticationService authenticationService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/sign-in")
    public SignInResponse login(@RequestBody SignInRequest signInRequest) {
        Authentication authentication = authenticationService.getAuthenticate(
                signInRequest.email(),
                signInRequest.password()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = tokenProvider.generateToken(signInRequest.email());
        return new SignInResponse(jwtToken);
    }
}
