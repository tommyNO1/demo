package com.o2o.dao;

import com.o2o.entity.Product;

public interface ProductDao {
    /*
    * 添加商品
    * @Param product
    * @Return effectedNum
    * */
    int insertProduct(Product product);

    /*
    * 查询商品信息
    * @Param productId
    * @Return product
    * */
    Product queryProductById(long productId);

    /*
    * 更新商品信息
    * @Param product
    * @Return effectedNum
    * */
    int updateProduct(Product product);
}
