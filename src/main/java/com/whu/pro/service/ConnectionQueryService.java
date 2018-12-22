package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.ConnectionQueryParam;
import com.whu.pro.mapper.result.ConnectionQueryResult;

public interface ConnectionQueryService {

    void InsertConnection(ConnectionQueryParam params);

    public ArrayList<ConnectionQueryResult> SeleConnections(ConnectionQueryParam params);

    void DeleteConnection(ConnectionQueryParam params);
}
