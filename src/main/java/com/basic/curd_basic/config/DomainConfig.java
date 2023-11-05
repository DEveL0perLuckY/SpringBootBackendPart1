package com.basic.curd_basic.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.basic.curd_basic.domain")
@EnableJpaRepositories("com.basic.curd_basic.repos")
@EnableTransactionManagement
public class DomainConfig {
}
