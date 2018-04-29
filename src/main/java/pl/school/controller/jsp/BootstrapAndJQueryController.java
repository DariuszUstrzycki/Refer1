package pl.school.controller.jsp;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class BootstrapAndJQueryController {

	@Controller
	public class JSPBootstrapController {    
		
	    @RequestMapping("/bootstrapandjquery")
	    public String gotoJSP(){
	        return "bootstrapandjquery";
	    }
	}
}
