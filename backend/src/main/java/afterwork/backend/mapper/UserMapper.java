package afterwork.backend.mapper;

import org.apache.ibatis.annotations.Mapper;

import afterwork.backend.model.UserRequest;
import afterwork.backend.model.UserResponse;

@Mapper
public interface UserMapper {
    /**
     * 회원 정보 저장 (회원가입)
     * @param params - 회원 정보
     */
    void save(UserRequest params);

    /**
     * 회원 상세정보 조회
     * @param loginId - UK
     * @return 회원 상세정보
     */
    UserResponse findByLoginId(String loginId);

    /**
     * 회원 정보 수정
     * @param params - 회원 정보
     */
    void update(UserRequest params);

    /**
     * 회원 정보 삭제 (회원 탈퇴)
     * @param id - PK
     */
    void deleteById(Long id);

    // /**
    //  * 회원 수 카운팅 (ID 중복 체크)
    //  * @param loginId - UK
    //  * @return 회원 수
    //  */
    // int countByLoginId(String loginId);

}