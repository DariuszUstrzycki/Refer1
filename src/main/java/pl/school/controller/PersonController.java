package pl.school.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import pl.school.entity.PersonForm;

@Controller                                // PO CO TU WebMvcConfigurer
public class PersonController implements WebMvcConfigurer {
	/*
	//////////////////////////////// spring boot tutorial ////////////////////////////
	// po co to jest?! "redirect:/results"; sugeruje ze /results jest bezpośrednio pod root, a viewControlller, ustala ze to bedzie pod
	// templates/results ?!!!
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")       // nawet nie potrzeba @ModelAttribute ?!!!
    public String showForm(PersonForm personForm) { // !!! model.addAttribute(PersonForm personForm)
        return "form"; // returns the form template. It includes a PersonForm in its method signature
                       // so the template can associate form attributes with a PersonForm.
    }

    @PostMapping("/")  // A personForm object marked up with @Valid to gather the attributes filled out in the form
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form"; // test for errors, and if so, send the user back to the original form template. 
                           // In that situation, all the error attributes are displayed.
        }

        return "redirect:/results";
    }
    */
    //////////////////////////// mykong /////////////////////////
    
	
 // inject via application.properties
 	@Value("${welcome.message:test}") // jak to skomentowac to wyswietli sie hello World
 	private String message = "Hello World";

 	@RequestMapping("/")
 	public String welcome(Map<String, Object> model) {
 		model.put("msg", this.message);
 		return "welcome";
 	}

}
