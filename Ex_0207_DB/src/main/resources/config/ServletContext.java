package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.korea.db.DeptController;
import com.korea.db.SawonController;

import dao.DeptDAO;
import dao.SawonDAO;


@Configuration
@EnableWebMvc
// @ComponentScan("com.korea.mvc")
public class ServletContext implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	

	
	@Bean
	public DeptController deptController(DeptDAO dao) {
		return new DeptController(dao);
	}
	
	@Bean
	public SawonController sawonController(SawonDAO dao) {
		return new SawonController(dao);
	}
	
}
