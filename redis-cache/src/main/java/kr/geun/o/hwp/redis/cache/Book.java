package kr.geun.o.hwp.redis.cache;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Book Entity
 *
 * @author akageun
 */
@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 7156526077883281623L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String name;

	@Column
	private int price;

	public Book() {
	}

	public Book(String name, int price) {
		this.name = name;
		this.price = price;
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

}
