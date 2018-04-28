package pl.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Welcome1Controller {

	//  http://localhost:8080/welcome1?name=User i http://localhost:8080/welcome1  
	@GetMapping("/welcome1")
	public String welcome1(@RequestParam(name = "name", required = false, defaultValue = "Worldie") String name,
			Model model) {
		model.addAttribute("name", name);
		return "welcome1";
	}

}