package com.stitchable.persistence;

import com.stitchable.api.ResultsItem;
import com.stitchable.api.Shop;
import com.stitchable.entity.Designer;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
/**
 * Tests getting etsy information from API
 */
public class EtsyDaoTest {

    @Test
    public void getShopSuccess() {
        EtsyShopDao dao = new EtsyShopDao();
        GenericDao designerDao = new GenericDao(Designer.class);
        Designer designer = (Designer)designerDao.getById(1);
        int shopCode = designer.getEtsyId();
        Shop shop = dao.getEtsyResponse(shopCode);
        List<ResultsItem> items = shop.getResults();
        assertNotNull(shop);
        for (ResultsItem item : items) {
            log.info("Shop name: " + item.getShopName());
            log.info("Shop url: " + item.getUrl());
            log.info("Shop image: " + item.getImageUrl760x100());
        }
    }

}
