package by.masha.cha.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "by.masha.cha.rest")
@EnableWebMvc
public class RestConfig {
}