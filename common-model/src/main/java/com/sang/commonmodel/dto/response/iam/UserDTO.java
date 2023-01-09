package com.sang.commonmodel.dto.response.iam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements Serializable {
    private String id;
    private String username;
    private String fullName;
    private String email;
    private String phoneNumber;
}
