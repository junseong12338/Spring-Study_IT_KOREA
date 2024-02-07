package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
//@Configuration : ���������� ����� ���� ������̼�, Bean�� ����ϱ� ���� ������̼�

@EnableWebMvc
//@EnableWebMvc : Enable�� �����ϴ� ������̼��� @Configuration�� ���� ���� Ŭ������ �������ν� �̿� ���õ� ��ɵ��� ���ϰ� �����ϰ� �ִ�.
//������̼� ����� SpringMvc�� �����Ҷ� �ʿ��� Bean �������� �ڵ����� ���ִ� ������̼��̴�.
@ComponentScan("com.korea.first")
public class ServletContext implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public InternalResourceViewResolver  resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
