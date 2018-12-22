package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.ConnectionQueryDao;
import com.whu.pro.mapper.param.ConnectionQueryParam;
import com.whu.pro.mapper.result.ConnectionQueryResult;
import com.whu.pro.service.ConnectionQueryService;

@Service("ConnectionQueryService")
public class ConnectionQueryImpl implements ConnectionQueryService {
    @Resource
    ConnectionQueryDao ciqd;

    public void InsertConnection(ConnectionQueryParam params) {
        ciqd.InsertConnection(params);
        // TODO Auto-generated method stub
    }

    public ArrayList<ConnectionQueryResult> SeleConnections(ConnectionQueryParam params) {
        ArrayList<ConnectionQueryResult> list = ciqd.SeleConnections(params);
        return list;
        // TODO Auto-generated method stub
    }

    public void DeleteConnection(ConnectionQueryParam params) {
        ciqd.DeleteConnection(params);
        // TODO Auto-generated method stub
    }
}