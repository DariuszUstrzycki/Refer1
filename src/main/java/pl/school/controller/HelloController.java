package pl.school.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController // @Controller and @ResponseBody
public class HelloController {
/*
	By default Spring Boot serves static content from resources in the classpath 
	at "/static" (or "/public"). The index.html resource is special because it is 
	used as a "welcome page" if it exists, which means it will be served up as 
	the root resource, i.e. at http://localhost:8080/ in our example.
	*/
	
    @RequestMapping("/hello")  
    public String index() {
        return "Greetings from Spring Boot HelloController!";
    }
    
    

}