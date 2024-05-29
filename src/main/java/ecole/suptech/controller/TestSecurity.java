package ecole.suptech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurity {

	@GetMapping("public")
	public String accueil() {
		return "Public";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "Admin";
	}
	
	@GetMapping("user")
	public String user() {
		return "User";
	}
}
