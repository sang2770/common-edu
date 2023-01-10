package com.sang.commonclient.config.security;


import com.sang.commonmodel.dto.response.iam.ClientToken;

public interface ClientAuthentication {

    ClientToken getClientToken(String clientId, String clientSecret);
}
