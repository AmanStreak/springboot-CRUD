package com.example.springdi.demo.configuration;
import com.example.springdi.demo.databases.BaseDB;
import com.example.springdi.demo.databases.DevDB;
import com.example.springdi.demo.databases.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "prod")
    public BaseDB prodDB() {
        return new ProdDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "dev")
    public BaseDB devDB() {
        return new DevDB();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
