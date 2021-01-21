package com.xizi;

import com.xizi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class SpringbootMongodbApplicationTests {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void tese1() {


        User user1 = new User();
        user1.setName("戏子22").setId("3").setAge(18).setGrade(100);

        mongoTemplate.insert(user1,"user");


        List<User> userList = mongoTemplate.findAll(User.class,"user");
        for(User user:userList){
            System.out.println(user);
        }
        userList.stream().forEach(use->{
            System.out.println(use);
        });
    }

}
