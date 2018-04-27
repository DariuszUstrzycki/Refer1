package pl.school.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController // @Controller and @ResponseBody
public class HelloController {

    @RequestMapping("/") //  maps / to the index() method. 
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    

}