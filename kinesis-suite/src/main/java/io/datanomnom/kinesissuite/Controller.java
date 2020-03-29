package io.datanomnom.kinesissuite;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Controller {

	@RequestMapping("/test")
	public String index() {
		return "Greetings from Spring Boot!";
	}

    
  @PostMapping("/facts")
  String newFact(@RequestBody Fact newFact) {
    
	System.out.println(newFact.toString());
    return "got it"+newFact.toString();
  }

}