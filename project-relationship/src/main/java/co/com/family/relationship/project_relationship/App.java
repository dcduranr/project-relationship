package co.com.family.relationship.project_relationship;

import org.mapstruct.MapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAutoConfiguration
@SpringBootApplication 
@ComponentScan(basePackages = {"co.com.family.relationship"})
@EnableJpaRepositories(basePackages = {"co.com.family.relationship.repository"})
@EntityScan(basePackages = {"co.com.family.relationship.entities"})
@MapperConfig(implementationPackage="co.com.family.relationship.mappers")
@EnableAsync
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

    }
}
