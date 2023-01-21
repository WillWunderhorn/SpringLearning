package ru.horn.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan
public class PersonConfig {

    @Bean
    public Person getPerson(){
        Person person = new Person();
        person.setName("Will");
        return person;
    }

    @Bean
    @Lazy
    public Dog getDog() {
        Dog dog = new Dog();
        dog.setName("Wolfy");
        dog.setAge(5);
        return dog;
    }

    @Bean
    @Lazy
    public Perrot getPerrot(){
        Perrot perrot = new Perrot();
        perrot.setName("Perrot");
        perrot.setAge(2);
        return perrot;
    }

}
