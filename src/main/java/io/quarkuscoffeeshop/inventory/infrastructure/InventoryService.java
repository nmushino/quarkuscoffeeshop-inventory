package io.quarkuscoffeeshop.inventory.infrastructure;

import io.quarkuscoffeeshop.inventory.domain.Inventory;
import io.quarkuscoffeeshop.inventory.domain.RestockInventoryCommand;
import io.quarkuscoffeeshop.inventory.domain.RestockItemCommand;
import io.quarkuscoffeeshop.inventory.domain.RestockItemResult;
import io.quarkuscoffeeshop.inventory.domain.events.RestockEvent;
import io.quarkuscoffeeshop.inventory.domain.events.RestockRequestedEvent;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class InventoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryService.class);

    @Inject
    @Channel("inventory-out")
    Emitter<RestockInventoryCommand> inventoryEmitter;

    public void restockItem(final RestockItemCommand restockItemCommand) {
        LOGGER.debug("restockItem: {}", restockItemCommand);

        List<RestockEvent> restockEventList = new ArrayList<RestockEvent>(){{
                add(new RestockRequestedEvent());
        }};

        Inventory inventory = Inventory.find("#Inventory.findByItem", restockItemCommand.getItem()).firstResult();
        LOGGER.debug("inventory: {}", inventory);

        RestockInventoryCommand restockInventoryCommand = new RestockInventoryCommand(restockItemCommand.getItem(), 99);

        RestockItemResult restockItemResult = new RestockItemResult(
                new ArrayList<RestockInventoryCommand>(){{
                add(restockInventoryCommand);
            }},restockEventList);

        restockItemResult.getRestockInventoryCommands().forEach(command -> {
            inventoryEmitter.send(command);
        });
    }

}
