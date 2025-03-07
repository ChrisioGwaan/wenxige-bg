package com.wenxige.bg.service;

import com.wenxige.bg.util.AuthenticationRequest;
import com.wenxige.bg.util.AuthenticationResponse;
import com.wenxige.bg.util.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
