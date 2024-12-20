package core.identityservice.internal.auth.service;

import core.identityservice.internal.auth.dto.AuthenticationRequest;
import core.identityservice.internal.auth.dto.AuthenticationResponse;

public interface AuthenticationService {
    public AuthenticationResponse authenticate(AuthenticationRequest request);
}
