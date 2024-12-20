package core.identityservice.internal.user.service.implement;

import core.identityservice.common.exception.AppException;
import core.identityservice.common.exception.ErrorCode;
import core.identityservice.entity.UserEntity;
import core.identityservice.enums.Role;
import core.identityservice.internal.role.dto.repository.RoleRepository;
import core.identityservice.internal.user.dto.UserCreationRequest;
import core.identityservice.internal.user.dto.UserResponse;
import core.identityservice.internal.user.mapper.UserMapper;
import core.identityservice.internal.user.repository.UserRepository;
import core.identityservice.internal.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserServiceImpl implements UserService {
    // Injection
    UserRepository userRepository;
    UserMapper userMapper;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse create(UserCreationRequest request) {
        UserEntity user = userMapper.toUserEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(new HashSet<>(roleRepository.findAllById(roles)));

        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new AppException(ErrorCode.USER_EXIST);
        }

        return userMapper.toUserResponse(user);
    }
}
