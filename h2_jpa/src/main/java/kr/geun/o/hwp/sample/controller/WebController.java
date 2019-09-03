package kr.geun.o.hwp.sample.controller;

import kr.geun.o.hwp.sample.repo.BookRepo;
import kr.geun.o.hwp.sample.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

/**
 * WEB Rest Controller
 *
 * @author akageun
 */
@RestController
public class WebController {

	@Autowired
	private BookRepo bookRepo;

	/**
	 * Get All Book Data
	 *
	 * @return
	 */
	@GetMapping("/book/list")
	public Iterable<BookEntity> getList() {
		return bookRepo.findAll();
	}

	/**
	 * View specific Book by id
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/book/{id}")
	public BookEntity getDetail(@PathVariable Long id) {
		return bookRepo.getOne(id);
	}

	/**
	 * New Book Data
	 *
	 * @param param
	 * @return
	 */
	@Transactional
	@PostMapping("/book")
	public BookEntity addBook(BookEntity param) {
		return bookRepo.save(param);
	}

	/**
	 * Modify Book Data
	 *
	 * @param param
	 * @return
	 */
	@Transactional
	@PutMapping("/book/{id}")
	public BookEntity modifyBook(BookEntity param) {
		return bookRepo.save(param);
	}

	/**
	 * Delete Book Data
	 *
	 * @param id
	 * @return
	 */
	@Transactional
	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable Long id) {
		bookRepo.deleteById(id);
		return "SUCCESS";
	}
}
