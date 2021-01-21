package com.xizi;

import com.xizi.config.EnableUser;
import com.xizi.config.MyImportSelector;
import com.xizi.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Map;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@Import(User.class)
//@Import(MyImportSelector.class)
//@EnableUser
public class SpringbootMongodbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootMongodbApplication.class, args);
        
        //通过Bean 的全限定类名获取Bean
//        Object user = context.getBean("com.xizi.pojo.User");
//        System.out.println(user);

        //二、通过Bean的类型获取Bean
//        User user1 = context.getBean(User.class);
//        System.out.println(user1);
//
//        //getBeansOfType()：获取bean的类型
//        Map<String, User> map = context.getBeansOfType(User.class);
//        System.out.println(map);



    }

}
