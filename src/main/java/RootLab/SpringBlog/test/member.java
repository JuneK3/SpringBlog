package RootLab.SpringBlog.test;

import lombok.Builder;
import lombok.Data;

@Data
public class member {
	private int id;
	private String username;
	private String password;
	private String email;

	@Builder
	public member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
