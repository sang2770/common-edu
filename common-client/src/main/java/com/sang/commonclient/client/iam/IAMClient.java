package com.sang.commonclient.client.iam;


import com.sang.commonclient.request.iam.ClientLoginRequest;
import com.sang.commonmodel.auth.UserAuthority;
import com.sang.commonmodel.dto.response.Response;
import com.sang.commonmodel.dto.response.iam.ClientToken;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@LoadBalancerClient(name = "iam")
@FeignClient(name = "iam", fallbackFactory = IAMClientFallback.class)
public interface IAMClient {

    int DEFAULT_PAGE_INDEX = 1;
    int DEFAULT_PAGE_SIZE = 2;

    @GetMapping("/api/users/{userId}/authorities")
    @LoadBalanced
    Response<UserAuthority> getUserAuthority(@PathVariable String userId);

    @GetMapping("/api/clients/me/authorities")
    @LoadBalanced
    Response<UserAuthority> getClientAuthority();

    @PostMapping("/api/client/authenticate")
    @LoadBalanced
    Response<ClientToken> getTokenClient(@RequestBody @Valid ClientLoginRequest request);


}
