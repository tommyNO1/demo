package com.o2o.service;

import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;
import com.o2o.exceptions.ShopOperationException;

import java.io.InputStream;

public interface ShopService {
    /*
    * 通过店铺id获取店铺信息
    * @param shopId
    * */
    Shop getByShopId(long shopId);
    /*
    * 更新店铺信息，包括对图片的处理
    * @param shop
    * @param shopImg
    * @return
    * @throws ShopOperationException
    * */
    ShopExecution modifyShop(Shop shop,InputStream shopImgInputStream,String fileName) throws ShopOperationException;
    /*
     * 新增店铺，包括新增图片
     * @param shop
     * @param shopImg
     * @return
     * @throws ShopOperationException
     * */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
