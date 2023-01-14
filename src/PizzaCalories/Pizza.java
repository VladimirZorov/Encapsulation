package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dought;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    public void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void setName(String name) {
        if (name == null|| name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDought(Dough dought) {
        this.dought = dought;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getOverallCalories() {
        double calories = 0;

        for (Topping topping : this.toppings) {
            calories += topping.calculateCalories();
        }
        calories += this.dought.calculateCalories();
        return calories;
    }

}
