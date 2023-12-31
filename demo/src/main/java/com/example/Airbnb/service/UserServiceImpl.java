package com.example.Airbnb.service;

import com.example.Airbnb.converter.UserConverter;
import com.example.Airbnb.converter.UserPostConverter;
import com.example.Airbnb.model.userModel.User;
import com.example.Airbnb.model.userModel.UserDto;
import com.example.Airbnb.model.userModel.UserPostDto;
import com.example.Airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    UserConverter userConverter = new UserConverter();
    UserPostConverter userPostConverter = new UserPostConverter();

    @Autowired
    UserRepository userRepository;


    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserDto findDtoById(Long id) {
        return UserConverter.convertToDto(userRepository.findById(id).get());
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserPostDto userPostDto) {
        User user = userPostConverter.convert(userPostDto);
        user = userRepository.save(user);

        System.out.println("User added or updated");

        return userConverter.convertToDto(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserPostDto findFullDtoById(Long id) {
        return UserPostConverter.convertToDto(userRepository.findById(id).get());
    }

    @Override
    public UserDto approve(Long id) {
        User user = userRepository.findById(id).get();
        user.setApproved(true);
        userRepository.save(user);
        return UserConverter.convertToDto(user);
    }
}
