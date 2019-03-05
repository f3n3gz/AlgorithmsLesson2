class PowRecursion {
    private final static double EPSILON = 0.000001;

    public static double Pow(double decimal, int exponent) {
        if (exponent == 0) {
            if (Math.abs(decimal) < EPSILON) {
                throw new IllegalArgumentException("decimal " + decimal + " exponent " + exponent);
            }
            return 1;
        } else if (exponent < 0) {
            return 1 / PowRec(decimal, exponent * -1);
        } else {
            return PowRec(decimal, exponent);
        }
    }

    private static double PowRec(double decimal, int exponent) {
        if (Math.abs(exponent) >= 2) {
            return decimal * Pow(decimal, --exponent);
        } else {
            return decimal;
        }
    }
}
