package com.jgji.selfassessment.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/my")
public class MyController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info")
    public String getUserInfo() {
        return "Security Config Test";
    }
}
