import java.util.ArrayList;
import java.util.List;

public class NewtonForwardDifferenceSeconOrder {

    public static List<Double> newtonForwardDifferenceSecondOrder(List<Double> xValues, List<Double> yValues) {
        double h = xValues.get(1) - xValues.get(0);
        int n = yValues.size();

        List<Double> secondOrderDerivatives = new ArrayList<>();

        // For each point(except two last)
        for (int i = 0; i < n - 2; i++) {  // For the second order of difference
            double fDoublePrime = (yValues.get(i + 2) - 2 * yValues.get(i + 1) + yValues.get(i)) / (h * h);
            secondOrderDerivatives.add(fDoublePrime);
        }

        return secondOrderDerivatives;
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

        List<Double> result = newtonForwardDifferenceSecondOrder(xValues, yValues);

        System.out.println("Newton Forward Difference Second Order:");
        System.out.println("Second-order derivatives: " + result);
    }
}
