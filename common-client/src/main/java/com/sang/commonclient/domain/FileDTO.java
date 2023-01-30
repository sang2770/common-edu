package com.sang.commonclient.domain;


import com.sang.commonmodel.domain.AuditableDomain;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Setter(AccessLevel.PRIVATE)
@Getter
public class FileDTO extends AuditableDomain {
    private String id;
    private String fileName;
    private String filePath;
    private String originFileName;
    private String owner;
    private String ownerId;
    private Boolean deleted;
}
