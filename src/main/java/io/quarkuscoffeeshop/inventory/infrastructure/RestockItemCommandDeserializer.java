package io.quarkuscoffeeshop.inventory.infrastructure;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import io.quarkuscoffeeshop.inventory.domain.RestockItemCommand;

public class RestockItemCommandDeserializer extends ObjectMapperDeserializer<RestockItemCommand> {

    public RestockItemCommandDeserializer() {
        super(RestockItemCommand.class);
    }
}
