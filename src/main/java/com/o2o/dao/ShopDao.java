package com.o2o.dao;

import com.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    /*
    * 返回queryShopList总数
    * */
    int queryShopCount(@Param("shopCondition") Shop shopCondition);
    /*
    * 分页查询店铺，可输入的条件有：店铺名（模糊），店铺状态，店铺类别，区域Id，owner
    * @Param shopCondition
    * @Param rowIndex 从第几行开始取数据
    * @Param pageSize 返回的条数
    * */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition,@Param("rowIndex") int rowIndex,@Param("pageSize") int pageSize);
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
