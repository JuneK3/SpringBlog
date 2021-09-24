package RootLab.SpringBlog.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class httpTestController {

	private static final String TAG = "HttpControllerTest: ";

	@GetMapping("/http/lombok")
	public String lombokTest(){
		member m2 = member.builder().username("root").password("root").email("asdf@asdf.com").build();
		System.out.println(TAG + "Getter -> " + m2.getId());
		m2.setId(5000);
		System.out.println(TAG + "Getter -> " + m2.getId());
		return "lombok test";
	}

	@GetMapping("/http/get")
	public String getTest(member m) {
		return "get요청 : " + m.getId() + " " + m.getUsername();
	}

	@PostMapping("/http/post")
	public String postTest(@RequestBody member m) {
		return "post요청 : " + m.getId() + " " + m.getUsername() + " " + m.getPassword() + " " + m.getEmail();
	}

	@PutMapping("/http/put")
	public String putTest() {
		return "get요청 : ";
	}

	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "get요청 : ";
	}
}
