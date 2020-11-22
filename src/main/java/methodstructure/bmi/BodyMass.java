package methodstructure.bmi;

public class BodyMass {

    private double weight;
    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double bodyMassIndex() {
        return weight / Math.pow(height, 2);
    }

    public BmiCategory body() {
        BmiCategory bmiCategory;
        double bmi = bodyMassIndex();
        if (bmi < 18.5) {
            bmiCategory = BmiCategory.UNDERWEIGHT;
        }
        else if (bmi > 25) {
            bmiCategory = BmiCategory.OVERWEIGHT;
        }
        else {
            bmiCategory = BmiCategory.NORMAL;
        }
        return bmiCategory;
    }

    public boolean isThinnerThan(BodyMass bodyMass ) {
        return this.bodyMassIndex() < bodyMass.bodyMassIndex() ? true : false;
    }
}
