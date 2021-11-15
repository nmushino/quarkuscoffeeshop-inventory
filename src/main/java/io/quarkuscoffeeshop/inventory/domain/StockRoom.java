package io.quarkuscoffeeshop.inventory.domain;

import io.quarkus.arc.Unremovable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletableFuture;

@ApplicationScoped @Unremovable
public class StockRoom {

    static final Logger logger = LoggerFactory.getLogger(StockRoom.class);

    public CompletableFuture<RestockItemCommand> handleRestockItemCommand(final Item item) {

        logger.debug("restocking: {}", item);

        return CompletableFuture.supplyAsync(() -> {

            switch (item) {
                case COFFEE_BLACK:
                    return restockBarista(item, 10);
                case COFFEE_WITH_ROOM:
                    return restockBarista(item, 10);
                case ESPRESSO:
                    return restockBarista(item, 10);
                case ESPRESSO_DOUBLE:
                    return restockBarista(item, 10);
                case CAPPUCCINO:
                    return restockBarista(item, 10);
                default:
                    return restockBarista(item, 10);
            }
        });
    }

    private void sleep(int seconds) {
        // model the time to restock
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private RestockItemCommand restockBarista(Item item, int seconds) {
        sleep(seconds);
        return new RestockItemCommand(item, 99);
    }

    private RestockItemCommand restockKitchen(Item item, int seconds) {
        sleep(seconds);
        return new RestockItemCommand(item, 99);
    }

}
