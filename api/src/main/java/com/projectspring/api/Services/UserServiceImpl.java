package com.projectspring.api.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.projectspring.api.Dto.UserDto;
import com.projectspring.api.Generic.GenericServiceImpl;
import com.projectspring.api.Mappers.UserMapper;
import com.projectspring.api.Models.RoleEntities;
import com.projectspring.api.Models.UserEntities;
import com.projectspring.api.Repositories.RoleRepositories;
import com.projectspring.api.Repositories.UserRepositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

/**
 * Classe encapsulant le code permettant de gérer les utilisateurs.
 * Doit nécessairement implémenter "UserDetailsService" qui sera utilisée par
 * "AuthenticationManager"
 */
@Service
public class UserServiceImpl
        extends GenericServiceImpl<UserEntities, UserDto, UserRepositories, UserMapper>
        implements UserDetailsService, UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final String USER_NOT_FOUND_MESSAGE = "L'utilisateur avec le nom {} n'existe pas.";
    private static final String USER_FOUND_MESSAGE = "L'utilisateur avec le nom {} existe en base de données.";

    private final UserRepositories userRepository;

    private final RoleRepositories roleRepository;

    private static final String USER_NOT_FOUND_WITH_NAME = "Utilisateur introuvable avec le nom: ";

    public UserServiceImpl(UserRepositories repository, UserMapper mapper, UserRepositories userRepository,
            RoleRepositories roleRepository) {
        super(repository, mapper);
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * Instancie un objet "User" qui est une instance d'une classe héritant de
     * "UserDetails"
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntities> user = Optional.ofNullable(userRepository.findByUsername(username));
        if (user.isEmpty()) {
            String message = String.format(USER_NOT_FOUND_MESSAGE, username);
            LOGGER.error(message);
            throw new UsernameNotFoundException(message);
        } else {
            LOGGER.debug(USER_FOUND_MESSAGE, username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.get().getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });

            return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
                    user.get().getPassword(),
                    authorities);
        }
    }

    public UserEntities createUser(UserDto userDto) {
        Optional<UserEntities> existingUser = Optional.ofNullable(userRepository.findByUsername(userDto.getUsername()));
        if (existingUser.isPresent()) {
            throw new RuntimeException("L'adresse ou le nom d'utilisateur est déjà utilisée.");
        }

        UserEntities user = toEntity(userDto);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        RoleEntities userRole = roleRepository.findByName("ROLE_USER");
        if (userRole == null) {
            RoleEntities newRole = new RoleEntities();
            newRole.setName("ROLE_USER");
            userRole = roleRepository.save(newRole);
        }

        user.getRoles().add(userRole);

        return userRepository.save(user);
    }
}
