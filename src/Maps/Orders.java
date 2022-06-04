package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {

    static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split(" ");
        Product product;
        Map<String, Product> productMap = new LinkedHashMap<>();
        while (!command[0].equals("buy")) {
            product = new Product(command[0], Double.parseDouble(command[1]), Integer.parseInt(command[2]));
            if (!productMap.containsKey(product.getName())) {
                productMap.put(product.getName(), product);
            } else {
                product.setPrice(Double.parseDouble(command[1]));
                product.setQuantity(productMap.get(product.getName()).getQuantity() + Integer.parseInt(command[2]));
                productMap.put(product.getName(), product);
            }
            command = scanner.nextLine().split(" ");
        }

        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            double totalPrice = entry.getValue().getPrice() * entry.getValue().getQuantity();
            System.out.printf("%s -> %.2f%n", entry.getKey(), totalPrice);
        }
    }
}
