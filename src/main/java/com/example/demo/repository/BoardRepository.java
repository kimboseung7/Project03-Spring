package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	// 필요한 경우 여기에 추가적인 사용자 정의 쿼리 메서드를 추가할 수 있습니다
}