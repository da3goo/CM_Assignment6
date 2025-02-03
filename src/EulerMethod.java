import java.util.ArrayList;
import java.util.List;

public class EulerMethod {


    interface Function {
        double f(double x, double y);
    }

    public static List<List<Double>> eulerMethod(Function f, double x0, double y0, double h, int n) {
        List<Double> xVals = new ArrayList<>();
        List<Double> yVals = new ArrayList<>();


        xVals.add(x0);
        yVals.add(y0);

        for (int i = 0; i < n; i++) {
            y0 = y0 + h * f.f(x0, y0); // Euler's method formula


            x0 = x0 + h;
            xVals.add(x0);
            yVals.add(y0);
        }

        List<List<Double>> result = new ArrayList<>();
        result.add(xVals);
        result.add(yVals);

        return result;
    }

    public static void main(String[] args) {

        Function f = (x, y) -> x + y;

        double x0 = 0;
        double y0 = 1;
        double h = 0.1;
        int n = 10;

        List<List<Double>> result = eulerMethod(f, x0, y0, h, n);
        System.out.println("Euler Method");


        System.out.println("x values: " + result.get(0));
        System.out.println("y values: " + result.get(1));
    }
}
