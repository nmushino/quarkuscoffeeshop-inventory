package io.quarkuscoffeeshop.inventory.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.StringJoiner;

@RegisterForReflection
public class RestockKitchenCommand implements CoffeeshopCommand{

    public final CommandType commandType = CommandType.RESTOCK_KITCHEN_COMMAND;

    Item item;

    int quantity;

    public RestockKitchenCommand() {
    }

    public RestockKitchenCommand(Item item) {
        this.item = item;
        this.quantity = 0;
    }

    public RestockKitchenCommand(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RestockKitchenCommand.class.getSimpleName() + "[", "]")
                .add("commandType=" + commandType)
                .add("item=" + item)
                .add("quantity=" + quantity)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestockKitchenCommand that = (RestockKitchenCommand) o;

        if (quantity != that.quantity) return false;
        if (commandType != that.commandType) return false;
        return item == that.item;
    }

    @Override
    public int hashCode() {
        int result = commandType != null ? commandType.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
