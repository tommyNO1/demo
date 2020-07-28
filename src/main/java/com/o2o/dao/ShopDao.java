package com.o2o.dao;

import com.o2o.entity.Shop;

public interface ShopDao {
    /*
    * 通过shop id 查询店铺
    * */
    Shop queryByShopId(long shopId);
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
