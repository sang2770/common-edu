package com.sang.commonmodel.auth;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@Builder
public class UserAuthenticationCmd {
    Object principal;
    Object credentials;
    Collection<? extends GrantedAuthority> authorities;
    Boolean isRoot;
    Boolean isClient;
    String userId;
    String token;
}
