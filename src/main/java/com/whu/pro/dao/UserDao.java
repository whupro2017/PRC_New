package com.whu.pro.dao;

import java.util.ArrayList;
import java.util.List;

import com.whu.pro.mapper.param.UserParam;
import com.whu.pro.mapper.result.TestUserResult;
import com.whu.pro.mapper.result.UserResult;

public interface UserDao {
	List<TestUserResult> getUsers(UserParam userParam);
	Integer insertUser(UserParam userParam);
	Integer deleteUser(String username);
	Integer updateUser(UserParam userParam);
	ArrayList<UserResult> getOtherUsers(String username);

}
