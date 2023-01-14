package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaAndToppingsNumber = reader.readLine().split(" ");
        String pizzaName = pizzaAndToppingsNumber[1];
        int numberOfToppings = Integer.parseInt(pizzaAndToppingsNumber[2]);
        PizzaCalories.Pizza pizza;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }


        String[] doughInfo = reader.readLine().split(" ");
        String flourType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        int weight = Integer.parseInt(doughInfo[3]);
        PizzaCalories.Dough dough;
        try {
           Dough dought = new Dough(flourType, bakingTechnique, weight);
            pizza.setDought(dought);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        String[] toppingInfo;
        while (numberOfToppings-- > 0) {
            toppingInfo = reader.readLine().split(" ");
            String toppingType = toppingInfo[1];
            double toppingWeight = Double.parseDouble(toppingInfo[2]);
            try {
                PizzaCalories.Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
        System.out.printf("%s – %.2f", pizzaName, pizza.

                getOverallCalories());
    }
}
