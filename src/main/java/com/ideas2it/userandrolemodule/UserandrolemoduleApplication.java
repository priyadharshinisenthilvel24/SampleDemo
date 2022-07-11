package com.ideas2it.userandrolemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableAutoConfiguration
//@Profile(value={"local","test","uat","prod"})
//@ComponentScan(basePackageClasses = UserRoleController.class)
@ComponentScan({"com.ideas2it.userandrolemodule"})
public class UserandrolemoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserandrolemoduleApplication.class, args);
	}

}
