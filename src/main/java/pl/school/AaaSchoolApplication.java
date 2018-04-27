package pl.school;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // @Configuration + @EnableAutoConfiguration (adding beans based on classpath ,
// @EnableWebMvc for a Spring MVC eg Dispatcher , @ComponentScan)
public class AaaSchoolApplication {

	public static void main(String[] args) {  // http://localhost:8080/
		SpringApplication.run(AaaSchoolApplication.class, args);
	}
	
	// uns on start up. It retrieves all the beans that were created either by your app or were 
	// automatically added thanks to Spring Boot. It sorts them and prints them out.
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
