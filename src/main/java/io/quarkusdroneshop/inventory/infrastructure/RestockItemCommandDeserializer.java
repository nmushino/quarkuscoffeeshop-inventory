package io.quarkusdroneshop.inventory.infrastructure;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import io.quarkusdroneshop.inventory.domain.RestockItemCommand;

public class RestockItemCommandDeserializer extends ObjectMapperDeserializer<RestockItemCommand> {

    public RestockItemCommandDeserializer() {
        super(RestockItemCommand.class);
    }
}
