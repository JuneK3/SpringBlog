package RootLab.SpringBlog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더패턴
@Entity // MySQL에 테이블 생성
//@DynamicInsert // insert시 null인 필드들을 제외시킴
public class User {
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에 연결된 DB의 넘버링 전략을 따라간다
	private int id;

	@Column(nullable = false, length = 30)
	private String username;

	@Column(nullable = false, length = 100) // 해쉬화로 암호화 할 예정
	private String password;

	@Column(nullable = false, length = 300)
	private String email;

	// @ColumnDefault("'user'") save(user)로 insert시 role에 null값을 저장하기 때문에 default값으로 초기화되지 않음
	// @DynamicInsert 사용 or save(user) 호출 직전에 setRole()로 지정
	@Enumerated(EnumType.STRING)
	private roleType role;

	@CreationTimestamp // 시간 자동입력
	private Timestamp createDate;
}
