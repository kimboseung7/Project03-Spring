package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

/*
 * 메모 엔티티 클래스를 처리하기 위한 인터페이스 만들기
 * */
@Transactional 
public interface MemoRepository extends JpaRepository<Memo, Integer> {
	//쿼리메소드
	// select * from tbl_memo where no between ? and ?
	List<Memo> findByNoBetween(int from, int to);

	List<Memo> findBynoLessThan(int no);

	/// 메모가 내용이 있는 데이터 검색
	List<Memo> findByTextIsNotNull(); // 조건을달아줌

	/// 메모의 번호를 기준으로, 역정렬
	List<Memo> findAllByOrderByNoDesc(); // 정렬을 달아줌
	
	// 메모의 번호가 3보다 작은 데이터 삭제
	void deleteMemoByNoLessThan (int mno); //안자 1개
	
	/*jpql 사용하기*/
	// @Query ---------------------------------------------------------
	
	//메모의 번호가 3보다 작은 데이터 검색
	// select * from tbl_memo where no < ?
	@Query("select m from Memo m where m.no < :mno")
	List<Memo> get1(@Param("mno") int mno);
	
	//메모의 내용이 있는 데이터 검색
	// select * from tbl_memo where text is not null
	
	@Query("select m from Memo m where m.text is not null")
	List<Memo> get2();
	
	//메모의 번호가 10에서 20사이인 데이터 검색
	//select * from tbl_memo where between ? and ? -- between 파라미터 2개 사용
	@Query("select m from Memo m where m.no between :from and :to")
	List<Memo> get3(@Param("from") int from, @Param("to") int to);
	
	/* 순수한 쿼리 사용하기 */
	
	//메모의 번호를 기준으로 역정렬
	
	//select * from tbl_memo orderby no desc
	
	@Query(value = "select * from Memo order by no desc", nativeQuery = true) 
	//true로 설정되면 직접 SQL 네이티브 쿼리를 사용할 수 있게 됩니다 / 직접 SQL 쿼리를 사용하여 데이터베이스에 접근할 때 유용 //asc 순정렬
	List<Memo> get4();
	
	
	
	
}

/*
 * JpaRepository를 상속받으면 crud 처리 메소드를 물려받음 JpaRepository를 사용할 때는 엔티티와 PK의 타입 지정해야
 * 함
 */