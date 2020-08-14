package com.o2o.dao;

import com.o2o.entity.Product;

public interface ProductDao {
    /*
    * 添加商品
    * @Param product
    * @Return effectedNum
    * */
    int insertProduct(Product product);
}
