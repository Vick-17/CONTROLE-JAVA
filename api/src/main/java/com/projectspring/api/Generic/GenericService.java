package com.projectspring.api.Generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<D extends BaseDto> {
    Page<D> findAll(Pageable pageable);

    Optional<D> findById(int id);

    D saveOrUpdate(D entity);

    void deleteById(int id);
}
