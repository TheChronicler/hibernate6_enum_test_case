package org.hibernate.bugs;

import jakarta.persistence.*;
//import javax.persistence.*;

@Entity
@Table(name = "test")
public class TestTbl {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "test_enum", length = 10)
	@Enumerated(EnumType.STRING)
	private TestEnum testEnum;
}
