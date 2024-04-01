package com.limecoding.bookgora.controller;

import com.limecoding.bookgora.Dto.UserCreateDto;
import com.limecoding.bookgora.Dto.UserResponseDto;
import com.limecoding.bookgora.Dto.UserUpdateDto;
import com.limecoding.bookgora.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 유저 관련 API
    @PostMapping
    public String createUser(@ModelAttribute UserCreateDto userCreateDto) {
        userService.createUser(userCreateDto);

        return "redirect:/home";
    }

    @GetMapping("/members")
    public List<UserResponseDto> getMembers() {
        return userService.getMembers();
    }

    @GetMapping("/member/{id}")
    public void getMember(@PathVariable Long id) {
        userService.getMember(id);
    }

    @DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable Long id) {
        userService.deleteMember(id);
    }

    @PutMapping("/member/{id}")
    public void updateMember(@PathVariable Long id, UserUpdateDto userUpdateDto) {
        userService.updateMember(id, userUpdateDto);
    }

    // 유저 VIEW 관련 API
    @GetMapping
    public String userCreateForm() {
        return "userCreateForm";
    }


}
