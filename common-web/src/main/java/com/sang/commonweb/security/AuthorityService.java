package com.sang.commonweb.security;


import com.sang.commonmodel.auth.UserAuthority;

public interface AuthorityService {

    UserAuthority getUserAuthority(String userId);

    UserAuthority getClientAuthority(String clientId);
}
