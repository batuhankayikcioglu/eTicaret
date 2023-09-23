package com.batdev.eticaret.app.ticaret.service;

import com.batdev.eticaret.app.ticaret.dto.CreateUserRequest;
import com.batdev.eticaret.app.ticaret.dto.UpdateUserRequest;
import com.batdev.eticaret.app.ticaret.dto.UserDto;
import com.batdev.eticaret.app.ticaret.dto.UserDtoConverter;
import com.batdev.eticaret.app.ticaret.exception.UserNotFoundException;
import com.batdev.eticaret.app.ticaret.model.User;
import com.batdev.eticaret.app.ticaret.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAllUsers() {
        return (List<UserDto>) userRepository.findAll().stream().map(userDtoConverter::convert).collect(Collectors.toSet());
    }

    public UserDto getUserById(Long id) {
        User user = findUserById(id);
        return userDtoConverter.convert(user);
    }

    public UserDto createUser(CreateUserRequest userRequest) {
        User user = new User(null,
                userRequest.getMail(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getMiddleName());
        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUser(Long id, UpdateUserRequest updateUserRequest) {

        User user = findUserById(id);
        User updateUser = new User(user.getId(),
                user.getMail(),
                updateUserRequest.getFirstName(),
                updateUserRequest.getLastName(),
                updateUserRequest.getMiddleName());
        return userDtoConverter.convert(userRepository.save(updateUser));

    }

    private User findUserById(Long id){
       return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User couldn't be found by following id" + id));


    }
}
