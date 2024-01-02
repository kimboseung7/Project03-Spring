package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@SpringBootTest
public class Quiz5 {
	@Autowired
	BookRepository repository;

	@Test
	public void 제목이자바프로그래밍입문인책검색() {
		List<Book> list = repository.get1("자바프로그래밍입문");
		for (Book book : list) {
			System.out.println(book);
		}
	}
	@Test
	public void 가격이3만원이상이고출판사남가람북스검색() {
		List<Book> list = repository.get2(30000, "남가람북스");
		for (Book book : list) {
			System.out.println(book);
		}
	}
	@Test
	public void 한빛출판사또는이지스퍼블리싱검색() {
		List<Book> list = repository.get3("한빛출판사", "이지스퍼블리싱");
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	
}
