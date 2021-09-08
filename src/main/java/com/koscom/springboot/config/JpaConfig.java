package com.koscom.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //Spring에서 설정클래스임을 알려주는 어노테이션
@EnableJpaAuditing//JPA Auditing 을 활성화시킴
public class JpaConfig {

}
