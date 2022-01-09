package by.academy.it;

import by.academy.it.config.ApplicationConfiguration;
import by.academy.it.pojo.Company;
import by.academy.it.pojo.Person;
import by.academy.it.service.CompanyService;
import by.academy.it.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        Person person = new Person(1L, "Ivan");
        Company company = new Company(2L, "Facebook");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfiguration.class);
        context.refresh();
        PersonService personService = context.getBean("personService", PersonService.class);
        CompanyService companyService = context.getBean("companyService", CompanyService.class);

        personService.print(person);
        companyService.print(company);

        context.close();
    }
}
