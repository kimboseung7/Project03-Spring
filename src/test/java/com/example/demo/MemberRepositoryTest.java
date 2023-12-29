package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@SpringBootTest
public class MemberRepositoryTest {
	@Autowired
	MemberRepository repository;
	
	@Test
	public void 데이터등록() {
		Member member1 = Member.builder().userId("user").password("1234").grade("사용자").build();
		repository.save(member1);
		
		Member member2 = Member.builder().userId("admin").password("1234").grade("관리자").build();
		repository.save(member2);
	}
}
