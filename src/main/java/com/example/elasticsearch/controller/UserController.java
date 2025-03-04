package com.example.elasticsearch.controller;

import com.example.elasticsearch.dto.User;
import com.example.elasticsearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);  // 创建文档[1,6](@ref)
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable String id) {
        return userService.findById(id);  // 按ID查询[1](@ref)
    }

    @GetMapping("/search")
    public List<User> search(@RequestParam String name) {
        return userService.searchByName(name);  // 名称搜索[1,9](@ref)
    }
}
