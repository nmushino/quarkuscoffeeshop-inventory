package io.quarkuscoffeeshop.inventory.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.StringJoiner;

@RegisterForReflection
public class RestockInventoryCommand extends RestockItemCommand implements CoffeeshopCommand{

    public final CommandType commandType = CommandType.RESTOCK_INVENTORY_COMMAND;

    Item item;

    int quantity;

    public RestockInventoryCommand() {
        super();
    }

    public RestockInventoryCommand(Item item) {
        this.item = item;
        this.quantity = 0;
    }

    public RestockInventoryCommand(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RestockInventoryCommand.class.getSimpleName() + "[", "]")
                .add("commandType=" + commandType)
                .add("item=" + item)
                .add("quantity=" + quantity)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        RestockInventoryCommand that = (RestockInventoryCommand) o;

        if (quantity != that.quantity) return false;
        if (commandType != that.commandType) return false;
        return item == that.item;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (commandType != null ? commandType.hashCode() : 0);
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
