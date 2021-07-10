import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator{

    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }

    @Override
    public int numIterations(double x0, double y0) {
        int i = 0;          //z^2 = (x + y(i))^2 == x^2 + 2xyi - y^2
        double x = 0, y = 0;
        while (x * x + y * y <= 4 && i < MAX_ITERATIONS){
            double xt = x * x - y * y + x0;
            y = 2 * Math.abs(x) * Math.abs(y) + y0;
            x = xt;
            i++;
        }
        if( i == MAX_ITERATIONS) {
            return -1;
        }
        else{
            return i;
        }
    }

    @Override
    public String toString() {
        return "BurningShip";
    }
}
