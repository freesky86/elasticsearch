package com.example.elasticsearch.service;

import com.example.elasticsearch.dto.User;
import com.example.elasticsearch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
       return userRepository.save(user);
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public List<User> searchByName(String name) {
        return userRepository.findByName(name);
    }

    public void delete(String id) {
        userRepository.deleteById(id);  // 删除文档[1](@ref)
    }
}
