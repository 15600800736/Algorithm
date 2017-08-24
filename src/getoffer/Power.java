package getoffer;

/**
 * Created by fdh on 2017/8/24.
 */
public class Power {
    public double power(double base, int exponent) {
        if (equals(base,0) && exponent == 0) {
            throw new RuntimeException("The base and exponent can't be both zero");
        }
        if (equals(base,0)) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = base;
        if (exponent == Integer.MIN_VALUE) {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                result *= base;
            }
            return result;
        }
        int posExponent = exponent;
        if (exponent < 0) {
            posExponent = -exponent;
        }

        for (int i = 0; i < posExponent - 1; i++) {
            result *= base;
        }

        if (exponent < 0) {
            result = 1 / result;
        }

        return result;
    }

    private boolean equals(double a, double b) {
        return a - b < 0.000000001 && a - b > -0.000000001;
    }
}
