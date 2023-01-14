package PizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.isEmpty()) {
            throw new IllegalArgumentException("Invalid topping input.");
        }

        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies")
                && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }
    public double calculateCalories() {
        double calories = 0;
        switch (this.toppingType) {
            case "Meat":
                calories = (this.weight * 2) * 1.2;
                break;
            case "Veggies":
                calories = (this.weight * 2) * 0.8;
                break;
            case "Cheese":
                calories = (this.weight * 2) * 1.1;
                break;
            case "Sauce":
                calories = (this.weight * 2) * 0.9;
                break;
            default:
                break;
        }

        return calories;
    }
}
