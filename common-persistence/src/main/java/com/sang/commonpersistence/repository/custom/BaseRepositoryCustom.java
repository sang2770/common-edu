package com.sang.commonpersistence.repository.custom;

import com.sang.commonmodel.query.BaseSearchQuery;

import java.util.List;
import java.util.Map;

public interface BaseRepositoryCustom<E> {
    List<E> search(BaseSearchQuery query);

    Long count(BaseSearchQuery query);

    StringBuilder createWhereQuery(BaseSearchQuery query, Map<String, Object> values);
    StringBuilder createOrderQuery(String sortBy);
}
