package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.ConnectionQueryParam;
import com.whu.pro.mapper.result.ConnectionQueryResult;

public interface ConnectionQueryDao {
    
    void InsertConnection(ConnectionQueryParam params);

    ArrayList<ConnectionQueryResult> SeleConnections(ConnectionQueryParam params);

    void DeleteConnection(ConnectionQueryParam params);
}
