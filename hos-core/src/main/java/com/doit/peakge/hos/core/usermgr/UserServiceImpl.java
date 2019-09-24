package com.doit.peakge.hos.core.usermgr;

import com.doit.peakge.hos.core.usermgr.dao.UserInfoMapper;
import com.doit.peakge.hos.core.usermgr.model.UserInfo;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Autowired
    UserInfoMapper userInfoMapper;


    @Override
    public boolean addUser(UserInfo userInfo) {
        userInfoMapper.addUser(userInfo);
        //todo add token
        return true;
    }

    @Override
    public boolean updateUserInfo(String userId, String password, String detail) {
        userInfoMapper.updateUserInfo(userId,
                Strings.isNullOrEmpty(password)?null:CoreUtil.getMd5Password(password),
                detail);
        return true;
    }

    @Override
    public boolean deleteUser(String userId) {
        //todo delete token and auth
        userInfoMapper.deleteUser(userId);
        return true;
    }

    @Override
    public UserInfo getUserInfo(String userId) {
        return userInfoMapper.getUserInfo(userId);
    }

    @Override
    public UserInfo checkPassword(String userName, String password) {
        return userInfoMapper.checkPassword(userName, password);
    }

    @Override
    public UserInfo getUserInfoByName(String userName) {
        return userInfoMapper.getUserInfoByName(userName);
    }
}
