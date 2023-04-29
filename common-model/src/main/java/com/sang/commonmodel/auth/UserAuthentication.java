package com.sang.commonmodel.auth;


import lombok.EqualsAndHashCode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@EqualsAndHashCode(callSuper = false)
public class UserAuthentication extends UsernamePasswordAuthenticationToken {

    private final boolean isRoot;

    private final boolean isClient;

    private final String userId;


    private final String token;

    private final List<String> grantedPermissions;

    public UserAuthentication(UserAuthenticationCmd cmd) {
        super(cmd.getPrincipal(), cmd.getCredentials(), cmd.getAuthorities());
        this.isRoot = cmd.isRoot != null && cmd.isRoot;
        this.isClient = cmd.isClient != null && cmd.isClient;
        this.userId = cmd.userId;
        this.token = cmd.token;
        this.grantedPermissions = CollectionUtils.isEmpty(cmd.authorities) ? new ArrayList<>()
                : cmd.authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }

    public boolean isRoot() {
        return isRoot;
    }

    public boolean isClient() {
        return isClient;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getToken() {
        return this.token;
    }

    public List<String> getGrantedPermissions() {
        if (CollectionUtils.isEmpty(this.grantedPermissions)) {
            return new ArrayList<>();
        }
        return grantedPermissions;
    }
}
