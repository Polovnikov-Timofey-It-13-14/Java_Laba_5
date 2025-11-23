public class FractionCache {
    private static int lastNumerator;
    private static int lastDenominator;
    private static double lastValue;
    private static boolean hasCache;

    public static double getDecimalValue(int numerator, int denominator) {
        if (hasCache && lastNumerator == numerator && lastDenominator == denominator) {
            return lastValue;
        }

        lastValue = (double) numerator / denominator;
        lastNumerator = numerator;
        lastDenominator = denominator;
        hasCache = true;
        return lastValue;
    }

    public static void clearCache(int numerator, int denominator) {
        if (hasCache && lastNumerator == numerator && lastDenominator == denominator) {
            hasCache = false;
        }
    }
}