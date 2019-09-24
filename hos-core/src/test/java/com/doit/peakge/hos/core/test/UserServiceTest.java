package com.doit.peakge.hos.core.test;

import com.doit.peakge.hos.core.usermgr.IUserService;
import com.doit.peakge.hos.core.usermgr.model.SystemRole;
import com.doit.peakge.hos.core.usermgr.model.UserInfo;
import com.doit.peakge.hos.mybatis.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceTest extends BaseTest {

    @Autowired
    @Qualifier("userServiceImpl")
    IUserService userService;

    @Test
    public void addUser(){
        UserInfo userInfo = new UserInfo("Tom", "123456", SystemRole.ADMIN, "no desc");
        userService.addUser(userInfo);
    }

    @Test
    public void getUser() {
        UserInfo userInfo = userService.getUserInfoByName("Tom");
        System.out
                .println(
                        userInfo.getUserId()
                                + "|"+ userInfo.getUserName()
                                + "|"+ userInfo.getSystemRole()
                                + "|"+ userInfo.getPassword());
    }
}
