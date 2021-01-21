package com.xizi.config;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 封装@Import注解
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(UserConfig.class)
public @interface EnableUser {
}
