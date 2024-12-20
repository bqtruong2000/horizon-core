package core.identityservice.internal.user.dto;

import core.identityservice.internal.role.dto.RoleResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String firstName;
    String lastName;
    String email;
    boolean emailVerified;
    LocalDate dob;
    Set<RoleResponse> roles;
    boolean isDeleted;
}
