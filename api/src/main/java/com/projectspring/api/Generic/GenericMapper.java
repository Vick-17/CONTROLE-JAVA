package com.projectspring.api.Generic;

public interface GenericMapper<D extends BaseDto, E extends BaseEntity> {

    D toDto(E entity);

    E toEntity(D dto);
}
