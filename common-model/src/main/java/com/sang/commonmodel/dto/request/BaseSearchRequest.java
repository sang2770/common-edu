package com.sang.commonmodel.dto.request;

import com.sang.commonmodel.dto.request.PagingRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseSearchRequest extends PagingRequest {
    private String keyword;
}
