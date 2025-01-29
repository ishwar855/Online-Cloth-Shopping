package DAOimpl;

import java.util.HashMap;
import java.util.Map;
import model.CartItem;

public class Cart {

    // A map to store the items in the cart, where the key is the item ID 
    // and the value is a CartItem object representing the item details.
    private Map<Integer, CartItem> items;

    // Constructor to initialize the cart with an empty HashMap.
    public Cart() {
        this.items = new HashMap<>();
    }

    /**
     * Adds an item to the cart.
     * If the item already exists in the cart, its quantity is increased by 1.
     * Otherwise, the item is added to the cart.
     * 
     * @param item the CartItem to be added
     */
    public void addItem(CartItem item) {
        int itemId = item.getItemId(); // Retrieve the item ID of the item to be added.
        if (items.containsKey(itemId)) { // Check if the item already exists in the cart.
            CartItem existingItem = items.get(itemId); // Get the existing item from the cart.
            existingItem.setQuantity(existingItem.getQuantity() + 1); // Increase the item's quantity by 1.
        } else {
            items.put(itemId, item); // Add the new item to the cart.
        }
    }

    /**
     * Increases the quantity of an existing item in the cart by 1.
     * 
     * @param itemId the ID of the item whose quantity is to be increased
     */
    public void increaseQuantity(int itemId) {
        if (items.containsKey(itemId)) { // Check if the item exists in the cart.
            CartItem item = items.get(itemId); // Get the item from the cart.
            item.setQuantity(item.getQuantity() + 1); // Increase the item's quantity by 1.
        }
    }

    /**
     * Decreases the quantity of an existing item in the cart by 1.
     * If the quantity becomes 0 or less, the item is removed from the cart.
     * 
     * @param itemId the ID of the item whose quantity is to be decreased
     */
    public void decreaseQuantity(int itemId) {
        if (items.containsKey(itemId)) { // Check if the item exists in the cart.
            CartItem item = items.get(itemId); // Get the item from the cart.
            int newQuantity = item.getQuantity() - 1; // Decrease the item's quantity by 1.
            if (newQuantity > 0) {
                item.setQuantity(newQuantity); // Update the item's quantity if it's still greater than 0.
            } else {
                removeItem(itemId); // Remove the item from the cart if its quantity is 0 or less.
            }
        }
    }

    /**
     * Removes an item from the cart based on its ID.
     * 
     * @param itemId the ID of the item to be removed
     */
    public void removeItem(int itemId) {
        items.remove(itemId); // Remove the item from the cart.
    }

    /**
     * Retrieves all the items currently in the cart.
     * 
     * @return a map of items in the cart
     */
    public Map<Integer, CartItem> getItems() {
        return items; // Return the map of items in the cart.
    }

    /**
     * Clears the cart by removing all items.
     */
    public void clear() {
        items.clear(); // Clear all items from the cart.
    }
}
