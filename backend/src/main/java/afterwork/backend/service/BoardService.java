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

    public int boardCount() {
        return  boardMapper.boardCount();
    }

    public List<BoardDomain> boardList() {
        return boardMapper.getBoardList();
    }
}
