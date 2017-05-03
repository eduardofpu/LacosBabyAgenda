package org.lacos.baby;

import org.lacos.baby.utils.AppContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppMain{

	public static void main(String[] args) {
		SpringApplication.run(AppContext.class, args);

	}

	/*
@RestController
@SpringBootApplication
public class AppMain extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(AppContext.class);
	}

	 */


}
