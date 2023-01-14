package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String trim, double parseDouble) {
    }

    public void Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName (String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
    
    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    public String getName() {
        return name;
    }


    public void buyProduct(Product product) {
    if (this.money < product.getCost()) {
        throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
    }
    this.money -= product.getCost();
    this.products.add(product);
        System.out.printf("%s bought %s%n", this.name, product.getName());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(String.format("%s - ", this.name));
        output.append(this.products.isEmpty() ? "Nothing bought"
                : output.append(products.stream().map(Product::getName).collect(Collectors.joining(", "))));
        return output.toString();

    }
}

