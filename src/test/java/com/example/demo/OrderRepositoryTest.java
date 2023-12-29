package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository repository;

	LocalDate localDate1 = LocalDate.of(2023,7,1);
	LocalDate localDate2 = LocalDate.of(2023, 7, 2);
	LocalDate localDate3 = LocalDate.of(2023, 7, 3);

	@Test
	public void 입력() {
		List<Order> list = new ArrayList<>();
		Order order1 = Order.builder().customerName("둘리").localDate(localDate1).shipAddress("인천 구월동")
				.build();
		Order order2 = Order.builder().customerName("또치").localDate(localDate2).shipAddress("인천 연수동")
				.build();
		Order order3 = Order.builder().customerName("도우너").localDate(localDate3).shipAddress("부산 동래동")
				.build();
		list.add(order1);
		list.add(order2);
		list.add(order3);

		 repository.saveAll(list);
	}
	@Test
	public void 제거() {
		repository.deleteAll();
	}
}
