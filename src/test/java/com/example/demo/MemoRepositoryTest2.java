package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;

@SpringBootTest // 컨테이너 임시 환경
public class MemoRepositoryTest2 {

	@Autowired
	MemoRepository memoRepository;

	@Test
	public void 번호가10에서20사이인_메모검색() {
		List<Memo> list = memoRepository.findByNoBetween(10, 20);
		// 자료형은 함수의 리턴타입

		for (Memo memo : list) {// 하나씩 출력
			System.out.println(memo);
		}

	}

	@Test
	public void 번호가10보다작은_메모검색() {
		List<Memo> list = memoRepository.findBynoLessThan(10);

		for (Memo memo : list) {// 하나씩 출력
			System.out.println(memo);
		}
	}

	@Test
	public void 텍스트가null이아닌_메모검색() {
		List<Memo> list = memoRepository.findByTextIsNotNull();

		for (Memo memo : list) {// 하나씩 출력
			System.out.println(memo);
		}
	}

	@Test
	public void 번호를기준으로역정렬한_메모검색() {
		List<Memo> list = memoRepository.findAllByOrderByNoDesc();
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	@Test
	public void 번호가5보다작은_메모삭제() {
		memoRepository.deleteMemoByNoLessThan(5);
		
		//@Transactional이 없다면 에러남
		//deleteby는 기본적으로 롤백처리가 되어 결과가 반영되지 않음
	}
	
}
