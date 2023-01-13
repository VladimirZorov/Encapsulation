package ClassBoxDataValidation;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public void setLength(double length) {
        checkForNegative(length, "Length");
        this.length = length;
    }

    public void setWidth(double width) {
        checkForNegative(width, "Width");
        this.width = width;
    }

    public void setHeight(double height) {
        checkForNegative(height, "Height");
        this.height = height;
    }

    private void checkForNegative (double argument, String argumentType) {
        if (argument <= 0) {
            throw new IllegalArgumentException(argumentType + "cannot be zero or negative.");
        }
    }


    public double calculateSurfaceArea() {
        return 2 * this.length * this.width + 2 * this.length * this.height
                + 2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {
        return  2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume() {
        return this.length * this.height * this.width;
    }
}

