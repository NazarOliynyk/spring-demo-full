package ua.com.owu.springdemofull.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
@ComponentScan
public class WebConfig implements WebMvcConfigurer {

            // from application.properties
    @Value("${custom.path}")
    String pathX;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // this String must be resolved in this method!!
        String path = System.getProperty("user.home")+ File.separator+pathX+File.separator;

        // the simple way
        //String path = System.getProperty("user.home")+ File.separator+"SPRING"+File.separator;
        System.out.println("path: "+path);

        // C://  - print it in browser
        // see index.html - href and src
        registry.addResourceHandler("/css/**").addResourceLocations("file:///"+path);
        registry.addResourceHandler("/js/**").addResourceLocations("file:///"+path);
    }
}
