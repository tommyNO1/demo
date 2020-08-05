package com.o2o.service;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

  T getById(Long id);

  void updateById( T t);

  void insertOne(T t) throws Exception;

  void deleteManyByIds(Long... ids);

  List<T> basePageList(Map map);

}
