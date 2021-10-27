package io.quarkuscoffeeshop.inventory.domain.events;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.debezium.outbox.quarkus.ExportedEvent;
import io.quarkuscoffeeshop.inventory.domain.Inventory;

import java.time.Instant;
import java.util.UUID;

public class RestockRequestedEvent implements RestockEvent, ExportedEvent<UUID, JsonNode> {

    private static ObjectMapper mapper = new ObjectMapper();

    private static final String TYPE = "RESTOCK";
    private static final String EVENT_TYPE = "RESTOCK_REQUESTED_EVENT";

    private final UUID aggregateId;

    private final JsonNode jsonNode;

    private final Instant timestamp;

    public RestockRequestedEvent(UUID aggregateId, JsonNode jsonNode, Instant instant) {
        this.aggregateId = aggregateId;
        this.jsonNode = jsonNode;
        this.timestamp = instant;
    }

    public static RestockRequestedEvent from(final Inventory inventory) {


        ObjectNode asJson = mapper.createObjectNode()
                .put("skuId", inventory.getProductMaster().getSkuId().toString())
                .put("item", inventory.getProductMaster().getItem().toString());

        return new RestockRequestedEvent(
                inventory.getProductMaster().getSkuId(),
                asJson,
                Instant.now());
    }

    @Override
    public UUID getAggregateId() {
        return this.aggregateId;
    }

    @Override
    public String getAggregateType() {
        return TYPE;
    }

    @Override
    public String getType() {
        return EVENT_TYPE;
    }

    @Override
    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public JsonNode getPayload() {
        return jsonNode;
    }
}
