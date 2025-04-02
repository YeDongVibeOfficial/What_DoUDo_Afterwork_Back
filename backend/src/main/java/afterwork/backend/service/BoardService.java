package afterwork.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import afterwork.backend.domain.BoardDomain;
import afterwork.backend.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //Mapper 생성자 사용 가능하게 함.
@Transactional(readOnly=true)
public class BoardService {

    private final BoardMapper boardMapper;
    
    public int boardCount() {return boardMapper.boardCount();}

    // public List<BoardDomain> getList() {return boardMapper.getList();}


    public List<BoardDomain> getList() {
        List<BoardDomain> list = boardMapper.getList();
        System.out.println("Board List: " + list);  // 로그 출력
        return list;
    }

    public BoardDomain getBoard(Long boardId) {return boardMapper.getBoard(boardId);}

    public List<BoardDomain> getAllSendBoard() {
        List<BoardDomain> sendBoardList = boardMapper.getList();
        return sendBoardList;
    }

}
