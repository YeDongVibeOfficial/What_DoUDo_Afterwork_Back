package afterwork.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import afterwork.backend.domain.BoardDomain;

//@Repositorty 어노테이션으로 해당 인터페이스가 저장소라는것을 명시. -> MapperScan의 대상 -> ~~~.xml을 통해 DB에 접근 가능

@Mapper
@Repository
public interface BoardMapper {
    int boardCount();

    List<BoardDomain> getList();

    BoardDomain getBoard(Long boardID);
}
