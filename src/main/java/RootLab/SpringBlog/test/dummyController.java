package RootLab.SpringBlog.test;

import RootLab.SpringBlog.model.User;
import RootLab.SpringBlog.model.roleType;
import RootLab.SpringBlog.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
public class dummyController {

	@Autowired // DI
	private userRepository userRepository;

	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id){
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저는 없습니다. id: " + id));
		return user;
	}

	@PostMapping("/dummy/join")
	public String join(User user){
		System.out.println("id: " + user.getId());
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("role: " + user.getRole());
		System.out.println("createDate: " + user.getCreateDate());
		user.setRole(roleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
}
