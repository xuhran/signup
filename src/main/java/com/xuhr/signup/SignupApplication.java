package com.xuhr.signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.xuhr.signup.mapper")
public class SignupApplication {
	public static void main(String[] args) {
		SpringApplication.run(SignupApplication.class, args);
	}
}

