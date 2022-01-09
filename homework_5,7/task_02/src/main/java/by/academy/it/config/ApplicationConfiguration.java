package by.academy.it.config;

import by.academy.it.annotation.MyService;
import by.academy.it.service.CompanyService;
import by.academy.it.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "by.academy.it")
public class ApplicationConfiguration {

    @Bean
    public PersonService personService() {
        return new PersonService();
    }

    @MyService
    public CompanyService companyService(){
        return new CompanyService();
    }
}
