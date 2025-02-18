package com.jtspringproject.JtSpringProject.Entity;

import java.util.List;
import java.util.ArrayList;

public class Cart {

    private String cartId;

    private List<Item> containedItems = new ArrayList<>();
    public Cart() {
        super();
    }

    public Cart(String cartId, List<Item> containedItems) {
        super();
        this.cartId = cartId;
        this.containedItems = containedItems;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<Item> getContainedItems() {
        return containedItems;
    }

    public void setContainedItems(List<Item> containedItems) {
        this.containedItems = containedItems;
    }

    public void addItem(Item item) {
        containedItems.add(item);
        System.out.println("Add Item: " + item.getName());
    }

    public void removeItem(Item item) {
        containedItems.remove(item);
        System.out.println("Remove Item: " + item.getName());
    }

    public float getTotalPrice() {

        float total  = containedItems.stream().map(item -> item.getPrice()).reduce(0.0f, (a, b) -> a + b);

        System.out.println("Total Price: " + total);
        return total;
    }

    public void clearCart(){
        containedItems.clear();
        System.out.println("Clear Cart");
    }

    public void checkout() {
        getTotalPrice();
        System.out.println("Checkout");
    }
}
