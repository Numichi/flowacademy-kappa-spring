package hu.flowacademy.kappa.services;

import hu.flowacademy.kappa.controllers.model.ShopRequest;
import hu.flowacademy.kappa.models.Shop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShopService {
    private final LoggerService logger;
    private int id = 0;
    private final Map<Integer, Shop> shops = new HashMap<>();

    ShopService(@Qualifier("loggerToConsoleService") LoggerService logger) {
        this.logger = logger;
    }

    public Map<Integer, Shop> getShops() {
        logger.log(shops.toString());

        return shops;
    }

    public void init(ShopRequest model) {
        logger.log(model.toString());

        var shop = new Shop();
        shop.setId(id++);
        shop.setName(model.getName());
        shop.setCategory(model.getCategory());
        shop.setSettlement(model.getSettlement());
        shop.setZip(model.getZip());
        shops.put(id, shop);
    }
}
