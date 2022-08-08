package neft.file.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.List;


@SpringBootApplication
public class file_management extends SpringBootServletInitializer {
	
	@Override  
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	{  
	return application.sources(file_management.class);  
	} 
	
	public static void main(String[] args) {
		SpringApplication.run(file_management.class, args);
		System.out.println("All Is Well");
	}


}
