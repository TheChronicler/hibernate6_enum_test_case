package org.hibernate.bugs;

import jakarta.persistence.*;

@Entity
@Table(name = "test", indexes = {
		@Index(name = "test_idx", columnList = "other_id", unique = false)
})
public class TestTbl {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "other_id", referencedColumnName = "id")
	private OtherTbl otherTbl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OtherTbl getOtherTbl() {
		return otherTbl;
	}

	public void setOtherTbl(OtherTbl otherTbl) {
		this.otherTbl = otherTbl;
	}
}
