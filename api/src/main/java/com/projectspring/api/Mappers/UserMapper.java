package com.projectspring.api.Mappers;


import org.mapstruct.Mapper;

import com.projectspring.api.Dto.UserDto;
import com.projectspring.api.Generic.GenericMapper;
import com.projectspring.api.Models.UserEntities;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper extends GenericMapper<UserDto, UserEntities> {

}