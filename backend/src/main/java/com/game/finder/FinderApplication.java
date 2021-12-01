package com.game.finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class FinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinderApplication.class, args);
	}

	  /*	Cross-origin resource sharing (CORS) is a W3C specification
		implemented by most browsers that allows you to specify in a
		flexible way what kind of cross domain requests are authorized,
		instead of using some less secured and less powerful hacks. */

}
