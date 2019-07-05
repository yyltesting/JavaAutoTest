package per.nydia.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")

public class Controller {
	@RequestMapping("")
	public String Hello() {
		
		return "Hello Spring boot!";
	}



}
