package io.quarkusdroneshop.inventory.domain.json;

import io.quarkusdroneshop.inventory.domain.RestockItemCommand;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

/**
 * Custom JSON deserializer for Kafka messages
 */
public class RestockItemCommandDeserializer extends JsonbDeserializer<RestockItemCommand> {

    public RestockItemCommandDeserializer() {
        super(RestockItemCommand.class);
    }
}
