package by.academy.it.annotation;

import org.springframework.context.annotation.Bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
@Bean(initMethod = "defaultInit", destroyMethod = "defaultDestroy")
public @interface MyService {
}
