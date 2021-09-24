package RootLab.SpringBlog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {
	@GetMapping("/test/home")
	public String testHome() {
		System.out.println("testHome");
		return "/home.html";
	}

	@GetMapping("/test/jsp")
	public String testJsp(){
		return "/test";
	}
}
