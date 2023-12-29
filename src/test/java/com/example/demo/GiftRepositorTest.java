package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;
import com.example.demo.repository.GiftRepository;

@SpringBootTest
public class GiftRepositorTest {

	@Autowired
	GiftRepository repository;

	@Test
	public void 입력() {

		Gift gift1 = Gift.builder().name("참치세트").price(10000).type("식품").build();
		Gift gift2 = Gift.builder().name("햄세트").price(20000).type("식품").build();
		Gift gift3 = Gift.builder().name("샴푸세트").price(30000).type("생활용품").build();
		Gift gift4 = Gift.builder().name("세차세트").price(40000).type("생활용품").build();
		Gift gift5 = Gift.builder().name("주방세트").price(50000).type("생활용품").build();
		Gift gift6 = Gift.builder().name("노트북").price(60000).type("가전제품").build();
		Gift gift7 = Gift.builder().name("벽걸이TV").price(70000).type("가전제품").build();

		repository.save(gift1);
		repository.save(gift2);
		repository.save(gift3);
		repository.save(gift4);
		repository.save(gift5);
		repository.save(gift6);
		repository.save(gift7);
		

	}
	@Test
	public void 일괄등록() {
		Gift gift1 = Gift.builder().name("참치세트").price(10000).type("식품").build();
		Gift gift2 = Gift.builder().name("햄세트").price(20000).type("식품").build();
		Gift gift3 = Gift.builder().name("샴푸세트").price(30000).type("생활용품").build();
		Gift gift4 = Gift.builder().name("세차세트").price(40000).type("생활용품").build();
		Gift gift5 = Gift.builder().name("주방세트").price(50000).type("생활용품").build();
		Gift gift6 = Gift.builder().name("노트북").price(60000).type("가전제품").build();
		Gift gift7 = Gift.builder().name("벽걸이TV").price(70000).type("가전제품").build();
		List<Gift> gifts = List.of(gift1,gift2,gift3,gift4,gift5,gift6,gift7);
		  repository.saveAll(gifts);
		

	

	}

	@Test
	public void 단권조회() {
		Optional<Gift> result = repository.findById(1);
		if (result.isPresent()) {
			Gift gift = result.get();
			System.out.println(gift);
		}
	}

	@Test
	public void 전체조회() {
		List<Gift> list = repository.findAll();
		for (Gift gift : list) {
			System.out.println(gift);
		}

	}

	@Test
	public void 데이터수정() {
		Optional<Gift> result = repository.findById(1);
		Gift gift = result.get();
		gift.setName("컴퓨터 용품");
		repository.save(gift);
	}

	@Test
	public void 하나제거() {
		repository.deleteById(1);
	}

	@Test
	public void 모두제거() {
		repository.deleteAll();
	}

}
