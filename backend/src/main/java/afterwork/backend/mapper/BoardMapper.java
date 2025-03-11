package afterwork.backend.mapper;

import org.springframework.stereotype.Repository;

//@Repositorty 어노테이션으로 해당 인터페이스가 저장소라는것을 명시. -> MapperScan의 대상 -> ~~~.xml을 통해 DB에 접근 가능
@Repository
public interface BoardMapper {
    int boardCount();
    
    List<Board> getList();
}
