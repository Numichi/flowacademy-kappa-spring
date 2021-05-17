package hu.flowacademy.kappa.services;

import hu.flowacademy.kappa.controllers.model.ShopRequest;
import hu.flowacademy.kappa.models.Shop;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShopService {
    private final LoggerService logger;
    private int id = 0;
    private final Map<Integer, Shop> shops = new HashMap<>();

    ShopService(LoggerToConsoleService logger) {
        this.logger = logger;
    }

    public Collection<Shop> getShops() {
        return shops.values();
    }

    public void setShops(Shop item) {
        item.setId(id);
        shops.put(id++, item);

        if (logger.log()) {
            System.out.println("log");
        }
    }

    public Shop getById(int id) {
        return shops.get(id);
    }

    public int size() {
        return shops.size();
    }

    public void clear() {
        shops.clear();
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
