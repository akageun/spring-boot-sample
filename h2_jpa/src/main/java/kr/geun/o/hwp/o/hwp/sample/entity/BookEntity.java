package kr.geun.o.hwp.o.hwp.sample.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Book Entity
 *
 * @author akageun
 */
@Entity
@Table(name = "book")
public class BookEntity implements Serializable {
	private static final long serialVersionUID = 810457109758530244L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String name;
	private int price;

	@Lob
	@Column
	private String desc;

	public BookEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
