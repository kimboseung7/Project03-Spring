package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	BookRepository repository;

	@Test
	public void 데이터추가() {
		Book book1 = Book.builder().price(20000).publisher("한빛출판사").title("자바프로그래밍입문").build();
		Book book2 = Book.builder().price(25000).publisher("남가람북스").title("스프링부트프로젝트").build();
		Book book3 = Book.builder().price(40000).publisher("남가람북스").title("실무로 끝내는 PHP").build();
		Book book4 = Book.builder().price(35000).publisher("이지퍼블리싱").title("알고리즘테스트").build();
		
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
		repository.save(book4);
	}

	@Test
	public void 데이터단권조회() {
		Optional<Book> result = repository.findById(1);
		if (result.isPresent()) {
			Book book = result.get();
			System.out.println(book);
		}
	}

	@Test
	public void 데이터전체조회() {
		List<Book> list = repository.findAll();
		for (Book book : list) {
			System.out.println(book);
		}
	}
	@Test
	public void 데이터수정() {
		Optional<Book> result = repository.findById(1);
		Book book = result.get();
		book.setTitle("김보승");
		repository.save(book);
	}

	

	@Test
	public void 데이터삭제() {
		repository.deleteById(1);
	}

	@Test
	public void 데이터전체삭제() {
		repository.deleteAll();
	}

}
