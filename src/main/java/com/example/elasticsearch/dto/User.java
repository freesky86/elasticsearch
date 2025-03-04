package com.example.elasticsearch.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "my_first_index")
@Data
public class User {
    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")  // 支持中文分词
    private String name;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Keyword)  // 精确匹配
    private String city;

}
