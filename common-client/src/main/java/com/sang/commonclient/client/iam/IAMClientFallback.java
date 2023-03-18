package com.sang.commonclient.client.iam;

import com.sang.commonclient.domain.UserDTO;
import com.sang.commonclient.request.iam.ClientLoginRequest;
import com.sang.commonmodel.auth.UserAuthority;
import com.sang.commonmodel.dto.request.FindByIdsRequest;
import com.sang.commonmodel.dto.response.Response;
import com.sang.commonmodel.dto.response.iam.ClientToken;
import com.sang.commonmodel.error.enums.ServiceUnavailableError;
import com.sang.commonmodel.exception.ForwardInnerAlertException;
import com.sang.commonmodel.exception.ResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IAMClientFallback implements FallbackFactory<IAMClient> {

    @Override
    public IAMClient create(Throwable cause) {
        return new FallbackWithFactory(cause);
    }

    @Slf4j
    static class FallbackWithFactory implements IAMClient {

        private final Throwable cause;

        FallbackWithFactory(Throwable cause) {
            this.cause = cause;
        }

        @Override
        public Response<UserAuthority> getUserAuthority(String userId) {
            log.error("Get user authorities {} error", userId, cause);
            if (cause instanceof ForwardInnerAlertException) {
                return Response.fail((RuntimeException) cause);
            }
            return Response.fail(new ResponseException(ServiceUnavailableError.IAM_SERVICE_UNAVAILABLE_ERROR));
        }

        @Override
        public Response<UserAuthority> getClientAuthority() {
            log.error("Get user authorities {} err", cause);
            if (cause instanceof ForwardInnerAlertException) {
                return Response.fail((RuntimeException) cause);
            }
            return Response.fail(new ResponseException(ServiceUnavailableError.IAM_SERVICE_UNAVAILABLE_ERROR));
        }

        @Override
        public Response<ClientToken> getTokenClient(ClientLoginRequest request) {
            log.error("Client login {} error", request.getClientId(), cause);
            if (cause instanceof ForwardInnerAlertException) {
                return Response.fail((RuntimeException) cause);
            }
            return Response.fail(new ResponseException(ServiceUnavailableError.IAM_SERVICE_UNAVAILABLE_ERROR));
        }

        @Override
        public Response<List<UserDTO>> getUserByIds(FindByIdsRequest request) {
            log.error("Request Ids {} error", request.getIds(), cause);
            if (cause instanceof ForwardInnerAlertException) {
                return Response.fail((RuntimeException) cause);
            }
            return Response.fail(new ResponseException(ServiceUnavailableError.IAM_SERVICE_UNAVAILABLE_ERROR));
        }
    }
}
