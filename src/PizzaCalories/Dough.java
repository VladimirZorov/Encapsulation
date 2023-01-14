package PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }


    public void setWeight(double weight) {
        if (weight < 0 || weight> 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public void setFlourType(String flourType) {
        if (!flourType.equals("white") || !flourType.equals("wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") || !bakingTechnique.equals("Chewy") ||
        !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        return 0;
    }

}
