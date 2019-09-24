package com.doit.peakge.hos.core.usermgr.model;

import com.doit.peakge.hos.core.usermgr.CoreUtil;

import java.util.Date;

public class UserInfo {
    private String userId;//用户id
    private String userName;//用户名--uuid
    private String password;//用户密码--MD5加密
    private String detail;//用户描述
    private SystemRole systemRole;//用户角色
    private Date createTime;//创建时间

    public UserInfo(String userName, String password, SystemRole systemRole, String detail) {
        this.userId = CoreUtil.getUUID();
        this.userName = userName;
        this.password = CoreUtil.getMd5Password(password);
        this.systemRole = systemRole;
        this.detail = detail;
        this.createTime = new Date();
    }

    public UserInfo() {

    }

    public SystemRole getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(SystemRole systemRole) {
        this.systemRole = systemRole;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
