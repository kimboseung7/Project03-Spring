package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;

@SpringBootTest // 컨테이너 임시 환경
public class MemoRepositoryTest3 {

	@Autowired
	MemoRepository memoRepository; // 객체를 생성 주입

	@Test
	public void 번호가3보다작은_메모검색() {
		List<Memo> list = memoRepository.get1(13);

		for (Memo memo : list) {
			System.out.println(memo);
		}
	}

	@Test
	public void 텍스트가null이아닌_메모검색() {
		List<Memo> list = memoRepository.get2();
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}

}
