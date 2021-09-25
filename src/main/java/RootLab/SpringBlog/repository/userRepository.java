package RootLab.SpringBlog.repository;

import RootLab.SpringBlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Integer> {
}
