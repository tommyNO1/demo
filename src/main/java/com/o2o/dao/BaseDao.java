package com.o2o.dao;


import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

  T queryById(long id);

  void insert(T t);

  void update(T t);

  void deleteById(Long id);

  List<T> getList(Map map);


}
