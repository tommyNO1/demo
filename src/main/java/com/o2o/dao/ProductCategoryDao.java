package com.o2o.dao;

import com.o2o.entity.ProductCategory;
import com.o2o.entity.Shop;

import java.util.List;

public interface ProductCategoryDao {
    /*
    * 获取店铺商品类别列表
    * @Param shopId
    * @Return List<ProductCategory>
    * */
    List<ProductCategory> queryProductCategoryList(long shopId);
    /*
    * 批量新增商品类别
    * @Param productCategoryList
    * @Return
    * */
    int batchInsertProductCategory(List<ProductCategory> productCategoriesList);
}
