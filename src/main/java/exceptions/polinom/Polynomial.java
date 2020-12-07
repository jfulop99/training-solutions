package exceptions.polinom;

public class Polynomial {

    private double [] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficientsString) {
        try {
            int length = coefficientsString.length;
            coefficients = new double[length];
            for (int i = 0; i < length; i++) {
                coefficients[i] = Double.parseDouble(coefficientsString[i]);
            }

        }catch (NullPointerException npe) {
            throw new NullPointerException("coefficientStrs is null");
        }
        catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
        }
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.length; i++)
            result += Math.pow(x,coefficients.length - i - 1) * coefficients[i];
        return result;
    }

    public double[] getCoefficients() {
        return coefficients;
    }
}
