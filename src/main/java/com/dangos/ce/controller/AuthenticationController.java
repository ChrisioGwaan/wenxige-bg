package com.dangos.ce.controller;

import com.dangos.ce.service.AuthenticationService;
import com.dangos.ce.util.AuthenticationRequest;
import com.dangos.ce.util.AuthenticationResponse;
import com.dangos.ce.util.R;
import com.dangos.ce.util.RegisterRequest;
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
