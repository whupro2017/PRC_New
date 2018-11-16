package com.whu.pro.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.whu.pro.dao.UserDao;
import com.whu.pro.mapper.param.UserParam;
import com.whu.pro.mapper.result.TestUserResult;

@Service("userDetailsService")
public class MyUserDetailService implements UserDetailsService {

    @Resource
    private UserDao userMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        System.out.println("*******************�û���" + username);
        UserParam userParam = new UserParam();
        userParam.setUsername(username);
        TestUserResult testUserResult = null;
        List<TestUserResult> list = (List<TestUserResult>) userMapper.getUsers(userParam);
        if (list == null || list.size() == 0) {
            System.out.println("��¼ʧ��");
            throw new UsernameNotFoundException(MyUserDetailService.class.getName());
        } else {
            System.out.println("��¼�ɹ�");
            testUserResult = list.get(0);
        }
        //娉ㄥ叆鍒皍serdetail涓�
        MyUserDetails userDetails = new MyUserDetails(testUserResult);
        return userDetails;
    }

}
