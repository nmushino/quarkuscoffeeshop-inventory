package io.quarkusdroneshop.inventory.infrastructure;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import io.smallrye.reactive.messaging.connectors.InMemoryConnector;

import java.util.HashMap;
import java.util.Map;

public class KafkaTestResource implements QuarkusTestResourceLifecycleManager {

    @Override
    public Map<String, String> start() {
        Map<String, String> env = new HashMap<>();
        Map<String, String> inventoryIn = InMemoryConnector.switchIncomingChannelsToInMemory("inventory-in");
        Map<String, String> inventoryOut = InMemoryConnector.switchOutgoingChannelsToInMemory("inventory-out");
        env.putAll(inventoryIn);
        env.putAll(inventoryOut);
        return env;
    }

    @Override
    public void stop() {
        InMemoryConnector.clear();
    }
}
