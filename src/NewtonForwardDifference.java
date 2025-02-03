import java.util.ArrayList;
import java.util.List;

public class NewtonForwardDifference {

    public static List<Double> newtonForwardDifferenceFirstOrder(List<Double> xValues, List<Double> yValues) {
        double h = xValues.get(1) - xValues.get(0);
        int n = yValues.size();

        List<Double> firstOrderDerivatives = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            double fPrime = (yValues.get(i + 1) - yValues.get(i)) / h;
            firstOrderDerivatives.add(fPrime);
        }

        return firstOrderDerivatives;
    }

    public static void main(String[] args) {

        List<Double> xValues = new ArrayList<>();
        xValues.add(0.0);
        xValues.add(1.0);
        xValues.add(2.0);
        xValues.add(3.0);

        List<Double> yValues = new ArrayList<>();
        yValues.add(0.0);
        yValues.add(1.0);
        yValues.add(4.0);
        yValues.add(9.0);

        List<Double> result = newtonForwardDifferenceFirstOrder(xValues, yValues);

        System.out.println("NewtonForwardDifference:");
        System.out.println("First-order derivatives: " + result);
    }
}
