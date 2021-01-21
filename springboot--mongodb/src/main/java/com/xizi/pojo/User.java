package com.xizi.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true )
@Document("user")
public class User {
    @Value("${user.id}")
    private String id;
    @Value("${user.name1}")
    private String name;
    @Value("${user.age}")
    private Integer age;
    @Value("${user.grade}")
    private Integer grade;
}
