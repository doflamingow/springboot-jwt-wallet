package com.bootcamp.springboot.one;

import com.bootcamp.springboot.one.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import({BeanConfig.class})
// kalo mau lebih dari 1 tinggal , diakhir string
@EntityScan({"com.bootcamp.springboot.one.model"})
@EnableJpaRepositories({"com.bootcamp.springboot.one.repository"})
public class OneApplication {
	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}

}
