package com.dangos.ce.service;

import com.dangos.ce.util.AuthenticationRequest;
import com.dangos.ce.util.AuthenticationResponse;
import com.dangos.ce.util.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
