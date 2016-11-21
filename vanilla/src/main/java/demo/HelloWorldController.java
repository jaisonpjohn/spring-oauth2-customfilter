package demo;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorldController {

	//Assume this is a persisted value
	public static boolean acceptedTOS;

	@RequestMapping("/")
	public String home() {
		return "Hello World !!!\n";
	}

	@RequestMapping(value = "/tos", method = RequestMethod.POST)
	public String acceptedTos() {
		acceptedTOS=true;
		return "OK - Thanks for Accepting Terms Of Service!!!\n";
	}

	@RequestMapping(value = "/error-no-tos", method = RequestMethod.GET)
	public String noTos() {
		return "You havent accepted Terms Of Service. Please POST against /tos end point !!!!\n";
	}
}
