package com.sang.commonmodel.dto.request;

import com.sang.commonmodel.validator.anotations.ValidateUUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class FindByIdsRequest extends Request {

    @NotEmpty(message = "IDS_REQUIRED")
    private List<@ValidateUUID String> ids;
}
