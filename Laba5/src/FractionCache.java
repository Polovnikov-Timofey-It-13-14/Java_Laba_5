public class FractionCache {
    private static Fraction cachedFraction = null;
    private static double cachedValue = 0.0;

    public static double getDecimalValue(Fraction fraction) {
        if (fraction.equals(cachedFraction)) {
            return cachedValue;
        }

        double value = (double) fraction.getNumerator() / fraction.getDenominator();
        cachedFraction = fraction;
        cachedValue = value;

        return value;
    }
}
