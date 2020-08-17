package com.o2o.service;

import com.o2o.dto.ImageHolder;
import com.o2o.dto.ProductExecution;
import com.o2o.entity.Product;
import com.o2o.entity.ProductImg;
import com.o2o.exceptions.ProductOperationException;

import java.io.InputStream;
import java.util.List;

public interface ProductService {
    /*
     * 添加商品信息以及图片处理
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     * */
    ProductExecution addProduct(Product product, ImageHolder thumbnail,
                                List<ImageHolder> productImgList) throws ProductOperationException;

    /*
     * 通过商品id查询商品信息
     * @param productId
     * @return product
     * */
    Product getProductById(long productId);

    /*
     * 修改商品信息以及图片处理
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return ProductExecution
     * @trows ProductOperationException
     * */
    ProductExecution modifyProduct(Product product, ImageHolder thumbnail,
                                   List<ImageHolder> productImgList) throws ProductOperationException;

    /*
     * 查询商品列表并分页，可输入的条件有：商品名，商品状态，店铺id，店铺类别
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     * */
    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
}
