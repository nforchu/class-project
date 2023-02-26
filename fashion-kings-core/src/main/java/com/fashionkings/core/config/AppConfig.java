package com.fashionkings.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class AppConfig {
	
	@Bean
	public UrlBasedViewResolver titlesViewResolver() {
		UrlBasedViewResolver tilesBasedViewResolver = new UrlBasedViewResolver();
		tilesBasedViewResolver.setViewClass(TilesView.class);
		return tilesBasedViewResolver;
	}
	
	@Bean
	public TilesConfigurer titlesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		String [] tileDefinitions = {"/WEB-INF/tiles.xml" };
		tilesConfigurer.setDefinitions(tileDefinitions);
		return tilesConfigurer;
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
			
		};
	}

}
