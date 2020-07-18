package com.o2o.dao;

import com.o2o.entity.Shop;

public interface ShopDao {
    /*
    * 新增店铺
    * @param shop
    * */
    int insertShop(Shop shop);
    /*
     * 新增店铺
     * @param shop
     * */
    int updateShop(Shop shop);
}
