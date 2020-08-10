package com.o2o.service;

import com.o2o.dto.ProductCategoryExecution;
import com.o2o.entity.ProductCategory;
import com.o2o.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {
    /*
     * 查询指定某个店铺下所有商品类别信息
     * */
    List<ProductCategory> getProductCategoryList(long shopId);

    /*
     * 批量添加商铺类别信息
     * */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;

    /*
     * 将此类别下的商品里的类别id置为空，再删除该商品类别
     * */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException;
}
