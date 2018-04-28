package pl.school.controller.jsp;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MyJSPController{
	
	
	@RequestMapping("/jsptest1")
	public String goToJSPPage() {
		return "testJSP1"; // hello.jsp
	}
	
	@Value("${application.message:Hello World}")
	private String welcome = "Hello World";

	@GetMapping("/jsptest2")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.welcome);
		return "testJSP2";
	}

	@RequestMapping("/fail")
	public String fail() {
		throw new MyException("Oh dear!");
	}

	@RequestMapping("/fail2")
	public String fail2() {
		throw new IllegalStateException(); // Whitelabel Error Page: This application has no explicit mapping for /error, so you are seeing this as a fallback.
//PROBLEMS WITH JSP: Creating a custom error.jsp page does not override the default view for error handling. 
// Custom error pages should be used instead.

	}
	// ta metoda włącza się gdy rzucany jest MyException i wyswietla obiekt MyRestResponse jako JSON
	@ExceptionHandler(MyException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody MyRestResponse handleMyRuntimeException(MyException exception) {
		return new MyRestResponse("Some data I want to send back to the client.");
	}

}
