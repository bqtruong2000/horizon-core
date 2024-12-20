package core.identityservice.internal.user.mapper;

import core.identityservice.entity.UserEntity;
import core.identityservice.internal.user.dto.UserCreationRequest;
import core.identityservice.internal.user.dto.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toUserEntity(UserCreationRequest request);
    UserResponse toUserResponse(UserEntity user);
    List<UserResponse> toUserResponseList(List<UserEntity> users);
}
