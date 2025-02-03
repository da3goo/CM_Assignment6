import java.util.ArrayList;
import java.util.List;

public class ModifiedEulerMethod {


    interface Function {
        double f(double x, double y);
    }

    public static List<List<Double>> modifiedEuler(Function f, double x0, double y0, double xEnd, double h) {
        List<Double> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();

        double x = x0;
        double y = y0;


        xValues.add(x0);
        yValues.add(y0);

        while (x < xEnd) {
            double yPredictor = y + h * f.f(x, y);
            double yCorrector = y + (h / 2) * (f.f(x, y) + f.f(x + h, yPredictor));

            x += h;
            y = yCorrector;

            xValues.add(x);
            yValues.add(y);
        }

        List<List<Double>> result = new ArrayList<>();
        result.add(xValues);
        result.add(yValues);

        return result;
    }

    public static void main(String[] args) {
        // Example usage of the Modified Euler method for dy/dx = x + y
        Function f = (x, y) -> x + y;

        double x0 = 0;
        double y0 = 1;
        double xEnd = 1;
        double h = 0.1;

        List<List<Double>> result = modifiedEuler(f, x0, y0, xEnd, h);


        System.out.println("x values: " + result.get(0));
        System.out.println("y values: " + result.get(1));
    }
}
