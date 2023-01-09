package com.sang.commonmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthority {
    private Instant lastAuthChangeAt;
    private String userId;
    private Boolean isRoot;
    private List<String> grantedPermissions;
}
