package com.example.fleet.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class OptimizedDataStructures {

    private Map<String, Integer> inventoryMap;
    private PriorityQueue<InventoryItem> inventoryQueue;

    public OptimizedDataStructures() {
        this.inventoryMap = new HashMap<>();
        this.inventoryQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.getQuantity(), b.getQuantity()));
    }

    public void addInventoryItem(String itemId, int quantity) {
        inventoryMap.put(itemId, inventoryMap.getOrDefault(itemId, 0) + quantity);
        inventoryQueue.offer(new InventoryItem(itemId, inventoryMap.get(itemId)));
    }

    public int getInventoryQuantity(String itemId) {
        return inventoryMap.getOrDefault(itemId, 0);
    }

    public InventoryItem getLowestQuantityItem() {
        return inventoryQueue.peek();
    }

    public void removeInventoryItem(String itemId) {
        if (inventoryMap.containsKey(itemId)) {
            inventoryMap.remove(itemId);
            inventoryQueue.removeIf(item -> item.getId().equals(itemId));
        }
    }

    private static class InventoryItem {
        private String id;
        private int quantity;

        public InventoryItem(String id, int quantity) {
            this.id = id;
            this.quantity = quantity;
        }

        public String getId() {
            return id;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}