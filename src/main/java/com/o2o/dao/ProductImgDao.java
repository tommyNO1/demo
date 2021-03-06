package com.o2o.dao;

import com.o2o.entity.ProductImg;

import java.util.List;

public interface ProductImgDao {

    /*
    * 批量添加商品图片
    * */
    int batchInsertProductImg(List<ProductImg> productImgList);

    /*
    * 删除商品图片
    * */
    int deleteProductImgByProductId(long productId);

    /*
    * 获取商品图片列表
    * */
    List<ProductImg> queryProductImgList(long productId);

}
