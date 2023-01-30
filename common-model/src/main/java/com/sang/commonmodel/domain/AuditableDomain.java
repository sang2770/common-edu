package com.sang.commonmodel.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.Instant;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuditableDomain implements Serializable {

    protected String createdBy;

    protected Instant createdAt;

    protected String lastModifiedBy;

    protected Instant lastModifiedAt;
}
