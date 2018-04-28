package pl.school;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import pl.school.entity.Customer;
import pl.school.repository.CustomerRepository;

/*
By default, Spring Boot will enable JPA repository support and look in the package (and its subpackages) 
where @SpringBootApplication is located. If your configuration has JPA repository interface definitions 
located in a package not visible, you can point out alternate packages using @EnableJpaRepositories and 
its type-safe basePackageClasses=MyRepository.class parameter.

*/

/*
The Thymeleaf configuration is also taken care of by @SpringBootApplication: by default templates are 
located in the classpath under templates/ and are resolved as views by stripping the '.html' suffix 
off the file name. Thymeleaf settings can be changed and overridden in a variety of 
ways depending on what you need to achieve,

*/

@SpringBootApplication // @Configuration + @EnableAutoConfiguration (adding beans based on classpath ,
// @EnableWebMvc for a Spring MVC eg Dispatcher , @ComponentScan)   @EnableJpaRepositories()
public class Application{ // extends SpringBootServletInitializer{ // SpringBootServletInitializer dodane by dzialało JSP niby, ale jak usunąłem to nic sie nie stało...
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	/*
	// ta czesc dodana by działalo JSP niby, ale jak usunąłem to nic sie nie stało...
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}*/


	public static void main(String[] args) {  // http://localhost:8080/
		SpringApplication.run(Application.class, args);
	}
	
	// Runs on start up. It retrieves all the beans that were created either by your app or were 
	// automatically added thanks to Spring Boot. It sorts them and prints them out.
	// Use CLR when you want to execute some piece of code exactly before the application startup completes
	@Bean                                     // ApplicationContext zostanie wstrzyknięte!!!
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) { 
              // implemention of the run method of CommandLineRunner (CLR provides access to application arguments as string array)
		return args -> {

            System.out.println("1. Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
	
	@Bean                          // CustomerRepository zostanie wstrzyknięte!!!
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("2. Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			
			// }
						log.info("The End");
					};
				}
}
