class PowRecursion {
    public static double Pow(double decimal, int exponent) {
        if (exponent < 0) return 1 / PowRec(decimal, exponent * -1);
        else return PowRec(decimal, exponent);
    }

    private static double PowRec(double decimal, int exponent) {
        if (exponent > 2) {
            return decimal * Pow(decimal, --exponent);

        } else {
            return decimal * decimal;
        }
    }
}
