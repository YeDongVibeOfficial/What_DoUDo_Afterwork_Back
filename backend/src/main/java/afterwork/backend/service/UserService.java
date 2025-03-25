package afterwork.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afterwork.backend.domain.UserDomain;
import afterwork.backend.mapper.UserMapper;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void registerUser(UserDomain user) {
        int count = userMapper.countByLoginId(user.getLoginId());
        if (count > 0) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }
        userMapper.insertUser(user);
    }

    public UserDomain login(String loginId, String password) {
        UserDomain user = userMapper.findByLoginId(loginId);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}