package com.sang.commonclient.client.storage;

import com.sang.commonclient.domain.FileDTO;
import com.sang.commonmodel.dto.response.Response;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@LoadBalancerClient(name = "storage")
@FeignClient(name = "storage", fallbackFactory = StorageClientFallBack.class )
public interface StorageClient {
    @PostMapping("/storages/upload-firebase")
    Response<FileDTO> uploadFileBase(@RequestParam("file") MultipartFile file) throws Exception;

    @PostMapping("/storages/find-by-id/{id}")
    Response<FileDTO> findById(@PathVariable String id);
}
