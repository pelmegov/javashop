package ru.pelmegov.javashop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.pelmegov.javashop.formatter.RoleFormatter;

@Configuration
@EnableWebMvc
public class MVCConfig extends WebMvcConfigurerAdapter {

    @Autowired
    RoleFormatter roleFormatter;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/bootstrap/**")) {
            registry.addResourceHandler("/webjars/bootstrap/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.0.0-alpha.6/");
        }
        if (!registry.hasMappingForPattern("/webjars/jquery/**")) {
            registry.addResourceHandler("/webjars/jquery/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/1.11.1/");
        }
        if (!registry.hasMappingForPattern("/resources/**")) {
            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        }
        if (!registry.hasMappingForPattern("/static/img/**")) {
            registry.addResourceHandler("/static/img/**").addResourceLocations("/static/img/");
        }
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(roleFormatter);
    }
}
