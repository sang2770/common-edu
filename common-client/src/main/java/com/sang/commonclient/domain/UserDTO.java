package com.sang.commonclient.domain;

import com.sang.commonmodel.domain.AuditableDomain;
import com.sang.commonmodel.enums.UserStatus;
import com.sang.commonmodel.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;


@Getter
@Setter
public class UserDTO extends AuditableDomain {
    private String id;

    private String code;
    private String username;

    private String password;

    private String fullName;

    private String email;

    private String phoneNumber;

    private LocalDate dayOfBirth;

    private Boolean deleted;

    private UserStatus status = UserStatus.ACTIVE;
    private String avatarFileId;
    private String avatarFileViewUrl;
    private Instant lastAuthChangeAt;
    private String classId;
    private UserType userType;
}
