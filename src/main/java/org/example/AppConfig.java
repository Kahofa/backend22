package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

    @Bean
    @Qualifier("urgent")
    public TaskService urgentTaskService(TaskService urgentTaskService) {
        return urgentTaskService;
    }
}
