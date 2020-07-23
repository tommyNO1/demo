package com.o2o.service;

import com.o2o.BaseTest;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import com.o2o.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺6");
        shop.setShopDesc("test5");
        shop.setShopDesc("test5");
        shop.setPhone("test5");
        shop.setShopImg("test5");
        shop.setPriority(1);
        shop.setAdvice("审核中");
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setCreateTime(new Date());
        File shopImg = new File("D:\\image\\bridge.png");
        InputStream inputStream = new FileInputStream(shopImg);
        ShopExecution shopExecution = shopService.addShop(shop,inputStream,shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(), shopExecution.getState());

    }
}
