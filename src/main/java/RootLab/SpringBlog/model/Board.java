package RootLab.SpringBlog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더패턴
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;

	@Column(nullable = false, length = 100)
	private String title;

	@Lob // 대용량 데이터
	private String content;

	@ColumnDefault("0")
	private int count;

	@ManyToOne(fetch = FetchType.EAGER) // Many:Board, One:User
	// fetch = FetchType.EAGER: Join을 통해 가져온 값을 바로 column에 저장
	// fetch = FetchType.LAZY: Join을 통해 가져온 값을 바로 column에 저장하지 않음
	// ManyTo... 관계는 fetch = FetchType.EAGER가 default
	// OneToMany 관계는 fetch = FetchType.LAZY가 default
	@JoinColumn(name="userId")
	private User user;

	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
	// @JoinColumn(name="replyId")은 부적절: column의 값은 복수의 값이 될 수 없음
	// mappedBy: 외래키가 아니므로 column을 생성하지 않음
	// 단순히 Join을 통해 값을 가져오기 위한 Annotation, field name을 할당하면 됨
	private List<Reply> reply;

	@CreationTimestamp
	private Timestamp createDate;
}
