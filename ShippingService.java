package Fawry;
import java.util.*;

public class ShippingService {

    public static void shipItems(List<Shippable> items) {
        if (items.isEmpty()) {
            System.out.println("No items to ship.");
            return;
        }

        System.out.println("** Shipment notice **");

        Map<String, ItemGroup> groupedItems = new LinkedHashMap<>();

        double totalWeight = 0.0;

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            if (!groupedItems.containsKey(name)) {
                groupedItems.put(name, new ItemGroup(1, weight));
            } else {
                groupedItems.get(name).quantity += 1;
            }

            totalWeight += weight;
        }

        for (Map.Entry<String, ItemGroup> entry : groupedItems.entrySet()) {
            int qty = entry.getValue().quantity;
            double singleWeight = entry.getValue().weight;

            if (singleWeight * 1000 < 1000) {
                int totalGrams = (int)(singleWeight * 1000 * qty);
                System.out.println(qty + "x " + entry.getKey() + " " + totalGrams + "g");
            } else {
                double totalKg = singleWeight * qty;
                System.out.println(qty + "x " + entry.getKey() + " " + totalKg + "kg");
            }
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }

    static class ItemGroup {
        int quantity;
        double weight;

        ItemGroup(int quantity, double weight) {
            this.quantity = quantity;
            this.weight = weight;
        }
    }
}
