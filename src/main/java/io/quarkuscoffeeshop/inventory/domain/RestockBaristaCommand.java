package io.quarkuscoffeeshop.inventory.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.StringJoiner;

@RegisterForReflection
public class RestockBaristaCommand extends RestockItemCommand implements CoffeeshopCommand{

    Item item;

    int quantity;

    public final CommandType commandType = CommandType.RESTOCK_BARISTA_COMMAND;

    public RestockBaristaCommand() {
    }

    public RestockBaristaCommand(Item item) {
        this.item = item;
        this.quantity = 0;
    }

    public RestockBaristaCommand(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RestockBaristaCommand.class.getSimpleName() + "[", "]")
                .add("item=" + item)
                .add("quantity=" + quantity)
                .add("commandType=" + commandType)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        RestockBaristaCommand that = (RestockBaristaCommand) o;

        if (quantity != that.quantity) return false;
        if (item != that.item) return false;
        return commandType == that.commandType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (commandType != null ? commandType.hashCode() : 0);
        return result;
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

    public CommandType getCommandType() {
        return commandType;
    }
}
