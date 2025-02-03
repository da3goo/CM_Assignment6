import java.util.ArrayList;
import java.util.List;

public class RungeKutta3rd {


    interface Function {
        double f(double x, double y);
    }

    public static List<List<Double>> rungeKutta3rd(Function f, double x0, double y0, double xEnd, double h) {
        List<Double> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();

        double x = x0;
        double y = y0;


        xValues.add(x0);
        yValues.add(y0);

        while (x < xEnd) {
            double k1 = h * f.f(x, y);
            double k2 = h * f.f(x + h / 2, y + k1 / 2);
            double k3 = h * f.f(x + h, y - k1 + 2 * k2);

            y += (1.0 / 6) * (k1 + 4 * k2 + k3);
            x += h;

            xValues.add(x);
            yValues.add(y);
        }

        List<List<Double>> result = new ArrayList<>();
        result.add(xValues);
        result.add(yValues);

        return result;
    }

    public static void main(String[] args) {

        Function f = (x, y) -> x + y;

        double x0 = 0;
        double y0 = 1;
        double xEnd = 1;
        double h = 0.1;

        List<List<Double>> result = rungeKutta3rd(f, x0, y0, xEnd, h);

        System.out.println("RangeKutta3rd:");
        System.out.println("x values: " + result.get(0));
        System.out.println("y values: " + result.get(1));
    }
}
