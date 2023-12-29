package com.example.demo;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository repository;

    @Test
    void 리파지토리객체를가져왔는지확인() {
        System.out.println("repository = " + repository);
    }

    @Test
    public void 데이터등록() {
        Board board1 = new Board(0, "1번글", "내용입니다", null, null);
        repository.save(board1); // 이 save 메서드는 JpaRepository에서 제공됩니다

        Board board2 = Board.builder().title("2번글").content("내용입니다").build();
        repository.save(board2);
    }
    @Test
    public void 데이터단건조회() {
    	Optional<Board> result = repository.findById(1); //게시물 번호가 1번인걸 조회
    	if(result.isPresent()) {
    		Board board = result.get();
    		System.out.println(board);
    	}
    }
    @Test
    public void 데이터젠체조회() {
    	List<Board> list = repository.findAll();
    	for(Board board : list) {
    		System.out.println(board);
    	}
    }
    @Test
    public void 데이터수정() {
    	Optional<Board> result = repository.findById(1);
    	Board board = result.get(); //엔티티 꺼내기
    	
    	//일부 값 변경
    	board.setContent("내용이수정되었습니다~");
    	
    	// 1번이 존재하는지 확인하고 update 실행
    	repository.save(board);
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