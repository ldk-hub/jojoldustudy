package com.koscom.springboot.config.auth.login;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//어노테이션을 생성함
@Target(ElementType.PARAMETER) // (1)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // (2)
}