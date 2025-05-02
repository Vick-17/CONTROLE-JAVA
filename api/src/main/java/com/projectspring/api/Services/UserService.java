package com.projectspring.api.Services;

import java.util.List;
import java.util.Set;

import com.projectspring.api.Dto.UserDto;
import com.projectspring.api.Generic.GenericService;
import com.projectspring.api.Models.UserEntities;

public interface UserService extends GenericService<UserDto> {

    UserEntities createUser(UserDto user);
}
