package com.ideas2it.userandrolemodule;

import com.ideas2it.userandrolemodule.controller.UserRoleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackageClasses = UserRoleController.class)
@ComponentScan({"com.ideas2it.userandrolemodule"})
public class UserandrolemoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserandrolemoduleApplication.class, args);
	}

}
