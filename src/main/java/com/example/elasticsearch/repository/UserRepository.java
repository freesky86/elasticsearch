package com.example.elasticsearch.repository;

import com.example.elasticsearch.dto.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    // 根据方法名自动生成查询
    List<User> findByName(String name);
    List<User> findByCity(String city);
    List<User> findByAgeBetween(Integer minAge, Integer maxAge);
}
