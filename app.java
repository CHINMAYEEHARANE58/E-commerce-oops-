import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public abstract void displayInfo();

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

class Electronics extends Product {
    private int warrantyPeriod;

    public Electronics(String name, double price, int warrantyPeriod) {
        super(name, price, "Electronics");
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronics: " + getName() + ", Price: $" + getPrice() + ", Warranty: " + warrantyPeriod + " months");
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
}

class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, String size) {
        super(name, price, "Clothing");
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("Clothing: " + getName() + ", Price: $" + getPrice() + ", Size: " + size);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

class Food extends Product {
    private String expirationDate;

    public Food(String name, double price, String expirationDate) {
        super(name, price, "Food");
        this.expirationDate = expirationDate;
    }

    @Override
    public void displayInfo() {
        System.out.println("Food: " + getName() + ", Price: $" + getPrice() + ", Expiration Date: " + expirationDate);
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.println("Enter Electronics details:");
        System.out.print("Name: ");
        String electronicName = scanner.nextLine();
        System.out.print("Price: ");
        double electronicPrice = scanner.nextDouble();
        System.out.print("Warranty Period (months): ");
        int warrantyPeriod = scanner.nextInt();
        scanner.nextLine(); 

        Product laptop = new Electronics(electronicName, electronicPrice, warrantyPeriod);
        products.add(laptop);

        
        System.out.println("Enter details for Clothing:");
        System.out.print("Name: ");
        String clothingName = scanner.nextLine();
        System.out.print("Price: ");
        double clothingPrice = scanner.nextDouble();
        System.out.print("Size: ");
        String clothingSize = scanner.next();
        scanner.nextLine(); 

        Product shirt = new Clothing(clothingName, clothingPrice, clothingSize);
        products.add(shirt);

        System.out.println("Enter details for Food:");
        System.out.print("Name: ");
        String foodName = scanner.nextLine();
        System.out.print("Price: ");
        double foodPrice = scanner.nextDouble();
        System.out.print("Expiration Date (YYYY-MM-DD): ");
        String expirationDate = scanner.next();

        Product milk = new Food(foodName, foodPrice, expirationDate);
        products.add(milk);

        System.out.println("\nProduct List:");
        for (Product product : products) {
            product.displayInfo();
        }

        scanner.close(); 
    }
}

