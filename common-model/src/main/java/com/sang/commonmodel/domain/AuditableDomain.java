package com.sang.commonmodel.domain;

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
public class AuditableDomain implements Serializable {

    protected String createdBy;

    protected Instant createdAt;

    protected String lastModifiedBy;

    protected Instant lastModifiedAt;
}
