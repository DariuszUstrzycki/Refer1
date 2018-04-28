package pl.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.school.entity.User;
import pl.school.repository.UserRepository;

@Controller
@RequestMapping(path = "/demorepo") // musisz wpisac: /demorepo/add?name=Darek&email=bla
public class MainController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
/*
	When the @ResponseBody annotation is used, Spring will return the data in a format that is acceptable 
	to the client. That is, if the client request has a header to accept json and Jackson-Mapper is present 
	in the classpath, then Spring will try to serialize the return value to JSON. If the request header 
	indicates XML as acceptable (accept=application/xml) and Jaxb is in the classpath and the return type 
	is annotated with Jaxb annotation, Spring will try to marshall the return value to XML.
	*/
	@GetMapping(path = "/all")  // @RequestMapping(method=GET)
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}