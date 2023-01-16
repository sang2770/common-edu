package com.sang.commonmodel.mapper;

import com.sang.commonmodel.dto.request.BaseSearchRequest;
import com.sang.commonmodel.query.BaseSearchQuery;
import org.mapstruct.Mapper;

public interface BaseAutoMapper {
    BaseSearchQuery from(BaseSearchRequest request);
}
