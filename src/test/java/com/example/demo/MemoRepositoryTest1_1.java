package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;

/*
 * 메모리 리자피토리를 사용하여
 * 메모테이블의 데이터를 등록, 조회, 수정, 삭제한다
 * */

// 기본적인 crud 기능
@SpringBootTest
public class MemoRepositoryTest1_1 {

	@Autowired
	MemoRepository memoRepository;

	@Test
	public void repository를가져왔는지확인() {
		System.out.println();
		System.out.println("memoRepository = " + memoRepository);
		System.out.println();

	}

	@Test
	public void 데이터등록() {

		Memo memo = Memo.builder().text("새글입니다").build();
		memoRepository.save(memo); // save라는 함수로 memo 추가
	}

	@Test
	public void 데이터일괄등록() {
		List<Memo> list = new ArrayList<>();

		Memo memo1 = new Memo(0, "새글입니다");
		Memo memo2 = new Memo(0, "null");

		list.add(memo1);
		list.add(memo2);

		memoRepository.saveAll(list);
	}

	@Test
	public void 데이터단건조회() {
		Optional<Memo> result = memoRepository.findById(5);

		if (result.isPresent()) { // 특정 조건에 데이터가 있는지 먼저 확인
			Memo memo = result.get();
			System.out.println(memo);
		}
	}

	@Test
	public void 데이터전체조회() { //
		List<Memo> list = memoRepository.findAll();

		for (Memo memo : list) {
			System.out.println(memo);
		}
	}

	@Test
	public void 데이터수정() {
		Memo memo = new Memo(1, "글이수정되었습니다");
		memoRepository.save(memo);

	}
	
	@Test
	public void 데이터삭제() { //단권 삭제
		
		memoRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {//일괄 삭제
		memoRepository.deleteAll();
	}
}