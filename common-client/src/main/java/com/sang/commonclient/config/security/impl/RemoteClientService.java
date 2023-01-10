package com.sang.commonclient.config.security.impl;

import com.sang.commonclient.client.iam.IAMClient;
import com.sang.commonclient.config.security.ClientAuthentication;
import com.sang.commonmodel.dto.response.iam.ClientToken;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class RemoteClientService implements ClientAuthentication {

    private final IAMClient iamClient;

    public RemoteClientService(@Lazy IAMClient iamClient) {
        this.iamClient = iamClient;
    }

    @Cacheable(cacheNames = "client-token", key = "#clientId",
            condition = "#clientId != null", unless = "#clientId == null || #result == null")
    @Override
    public ClientToken getClientToken(String clientId, String clientSecret) {
//        Response<ClientToken> clientTokenResponse = iamClient.getTokenClient(new ClientLoginRequest(clientId, clientSecret));
//        if (clientTokenResponse.isSuccess() && clientTokenResponse.getData() != null) {
//            return clientTokenResponse.getData();
//        }
        return null;
    }
}
