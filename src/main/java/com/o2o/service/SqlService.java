package com.o2o.service;

import com.o2o.entity.PersonInfo;

import java.util.List;
import java.util.Map;

public interface SqlService {

  List<Map<String, Object>> executeSql(String sql, PersonInfo personInfo) throws Exception;


}
