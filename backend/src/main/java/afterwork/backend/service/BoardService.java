package afterwork.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import afterwork.backend.domain.BoardDomain;
import afterwork.backend.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class BoardService {
    private final BoardMapper boardMapper;
    
    public int boardCount() { return boardMapper.boardCount(); }
    public List<BoardDomain> getList() { return boardMapper.getList(); }
    public BoardDomain getBoard(Long boardId) { return boardMapper.getBoard(boardId); }
    // public List<BoardDomain> getAllSendBoard() {  // <-- 이 메서드가 존재하는지 확인!
    //     return boardMapper.getList();
    // }
}

