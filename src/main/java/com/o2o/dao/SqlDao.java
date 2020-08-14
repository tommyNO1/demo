package com.o2o.dao;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public interface SqlDao {

  //执行sql
  List<Map<String, Object>> executeSql(String sql);

  //记录sql
  void recordSql(String sql,  String userName, Date recordTime);
}
