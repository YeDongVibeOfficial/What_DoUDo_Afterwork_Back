package afterwork.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import afterwork.backend.domain.UserDomain;


@Mapper
public interface UserMapper {
    void insertUser(UserDomain user);
    UserDomain findByLoginId(@Param("loginId") String loginId);
    int countByLoginId(@Param("loginId") String loginId); 
}