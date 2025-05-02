package com.projectspring.api.Generic;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public abstract class BaseDto {
    private Long id;
}
