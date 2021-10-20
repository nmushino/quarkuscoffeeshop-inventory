package io.quarkuscoffeeshop.inventory.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.StringJoiner;

@RegisterForReflection
public class RestockItemCommand implements CoffeeshopCommand{

    Item item;

    int quantity;

    public CommandType commandType;

    /**
     * Default empty constructor
     */
    public RestockItemCommand() {
    }

    /**
     * Constructor for use when an item is 86'd
     *
     * @param item Item
     */
    public RestockItemCommand(Item item){
        this.item = item;
        this.quantity = 0;
    }

    /**
     *
     * @param item Item
     * @param quantity int
     */
    public RestockItemCommand(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public RestockItemCommand(Item item, int quantity, CommandType commandType) {
        this.item = item;
        this.quantity = quantity;
        this.commandType = commandType;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RestockItemCommand.class.getSimpleName() + "[", "]")
                .add("item=" + item)
                .add("quantity=" + quantity)
                .add("commandType=" + commandType)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestockItemCommand that = (RestockItemCommand) o;

        if (quantity != that.quantity) return false;
        if (item != that.item) return false;
        return commandType == that.commandType;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
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
}
