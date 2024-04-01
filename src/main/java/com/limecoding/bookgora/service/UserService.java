package com.limecoding.bookgora.service;

import com.limecoding.bookgora.Dto.UserCreateDto;
import com.limecoding.bookgora.Dto.UserResponseDto;
import com.limecoding.bookgora.Dto.UserUpdateDto;
import com.limecoding.bookgora.entity.User;
import com.limecoding.bookgora.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;


    public void createUser(UserCreateDto userCreateDto) {
        userRepository.save(userCreateDto.toEntity());
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> getMembers() {
        return userRepository.findAll()
                .stream().map(UserResponseDto::new).toList();
    }

    @Transactional(readOnly = true)
    public UserResponseDto getMember(Long id) {
        return new UserResponseDto(userRepository.findById(id).orElseThrow());
    }

    public void deleteMember(Long id) {
        userRepository.deleteById(id);
    }

    public void updateMember(Long id, UserUpdateDto userUpdateDto) {
        User findUser = userRepository.findById(id).orElseThrow();
        findUser.update(userUpdateDto);
    }
}
