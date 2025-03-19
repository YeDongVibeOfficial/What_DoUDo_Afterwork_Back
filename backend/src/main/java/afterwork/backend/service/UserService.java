package afterwork.backend.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import afterwork.backend.domain.UserDomain;
import afterwork.backend.mapper.UserMapper;
import afterwork.backend.model.UserRequest;
import afterwork.backend.model.UserResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 정보 저장 (회원가입)
     * @param params - 회원 정보
     * @return PK
     */
    @Transactional
    public Long saveMember(final UserRequest params) {
        params.encodingPassword(passwordEncoder);
        userMapper.save(params);
        return params.getId();
    }

    /**
     * 회원 상세정보 조회
     * @param loginId - UK
     * @return 회원 상세정보
     */
    public UserResponse findMemberByLoginId(final String loginId) {
        return userMapper.findByLoginId(loginId);
    }

    ///왜 오류생김

    /**
     * 회원 정보 수정
     * @param params - 회원 정보
     * @return PK
     */
    @Transactionalsss
    public Long updateMember(final UserRequest params) {
        params.encodingPassword(passwordEncoder);
        userMapper.update(params);
        return params.getId();
    }

    /**
     * 회원 정보 삭제 (회원 탈퇴)
     * @param id - PK
     * @return PK
     */
    @Transactional
    public Long deleteMemberById(final Long id) {
        userMapper.deleteById(id);
        return id;
    }


    /**
     * 회원 수 카운팅 (ID 중복 체크)
     * @param loginId - UK
     * @return 회원 수
     */
    public int countMemberByLoginId(final String loginId) {
        return userMapper.countByLoginId(loginId);
    }

}