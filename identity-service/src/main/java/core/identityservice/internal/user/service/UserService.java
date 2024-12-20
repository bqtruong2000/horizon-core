package core.identityservice.internal.user.service;

import core.identityservice.internal.user.dto.UserCreationRequest;
import core.identityservice.internal.user.dto.UserResponse;

public interface UserService {
    public UserResponse create(UserCreationRequest request);
}
