package com.heyufei.user.controller;

import com.heyufei.common.result.ResponseMessage;
import com.heyufei.user.entity.User;
import com.heyufei.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author HeYuFei
 * @since 2023-04-07  17:20
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private UserService userService;


    @PostMapping("/login")
    public ResponseMessage login(@RequestBody User user) {
        return ResponseMessage.success(userService.login(user));
    }
}
