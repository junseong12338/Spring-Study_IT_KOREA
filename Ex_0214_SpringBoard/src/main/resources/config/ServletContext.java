package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.korea.board.BoardController;

import dao.BoardDAO;


@Configuration
@EnableWebMvc
//@ComponentScan("com.korea.board")
public class ServletContext implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public BoardController boardController(BoardDAO boardDAO) {
		return new BoardController(boardDAO);
	}

}
