package com.o2o.service.impl;

import com.o2o.dao.SqlDao;
import com.o2o.entity.PersonInfo;
import com.o2o.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SqlServiceImpl implements SqlService {

  @Autowired
  private SqlDao sqlDao;

  @Override
  public List<Map<String, Object>> executeSql(String sql, PersonInfo personInfo) throws Exception {
    String keyWord = sql.trim().substring(0, 6).toLowerCase();
    if(!"select".equals(keyWord) && personInfo.getUserType() == 3){
      throw new Exception("only begin with select");
    }
    List<Map<String, Object>> maps = sqlDao.executeSql(sql);
    sqlDao.recordSql(sql, personInfo.getName(), new Date());
    return maps;
  }
}
