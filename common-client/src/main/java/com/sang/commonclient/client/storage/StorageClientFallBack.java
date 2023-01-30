package com.sang.commonclient.client.storage;

import com.sang.commonclient.domain.FileDTO;
import com.sang.commonmodel.dto.response.Response;
import com.sang.commonmodel.error.enums.ServiceUnavailableError;
import com.sang.commonmodel.exception.ForwardInnerAlertException;
import com.sang.commonmodel.exception.ResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class StorageClientFallBack implements FallbackFactory<StorageClient> {

    @Override
    public StorageClient create(Throwable cause) {
        return new FallbackWithFactory(cause);
    }
    @Slf4j
    static class FallbackWithFactory implements StorageClient{
        private final Throwable cause;

        FallbackWithFactory(Throwable cause) {
            this.cause = cause;
        }

        @Override
        public Response<FileDTO> uploadFileBase(MultipartFile file) throws Exception {
            log.error("Upload file {} failed!", file.getOriginalFilename());
            if (cause instanceof ForwardInnerAlertException) {
                return Response.fail((RuntimeException) cause);
            }
            return Response.fail(new ResponseException(ServiceUnavailableError.STORAGE_SERVICE_UNAVAILABLE_ERROR));
        }

        @Override
        public Response<FileDTO> findById(String id) {
            log.error("file id {} not found!", id);
            if (cause instanceof ForwardInnerAlertException) {
                return Response.fail((RuntimeException) cause);
            }
            return Response.fail(new ResponseException(ServiceUnavailableError.STORAGE_SERVICE_UNAVAILABLE_ERROR));
        }
    }
}
