package com.wenxige.bg.controller;

import com.wenxige.bg.service.AuthenticationService;
import com.wenxige.bg.util.AuthenticationRequest;
import com.wenxige.bg.util.AuthenticationResponse;
import com.wenxige.bg.util.R;
import com.wenxige.bg.util.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public R<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        return R.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/authenticate")
    public R<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return R.ok(authenticationService.authenticate(authenticationRequest));
    }

}
