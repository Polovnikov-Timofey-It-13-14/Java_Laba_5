import java.util.Objects;

public final class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;

    // Конструкторы
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("Знаменатель 0");
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int number) {
        this(number, 1);
    }

    public Fraction(double value) {
        this((int)(value * 10000), 10000);
    }

    // Геттеры
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public double getDecimalValue() {
        return FractionCache.getDecimalValue(this.numerator, this.denominator);
    }

    // Сеттеры
    @Override
    public void setNumerator(int numerator) {
        FractionCache.clearCache(this.numerator, this.denominator);
        setValues(numerator, this.denominator);
    }

    @Override
    public void setDenominator(int denominator) {
        FractionCache.clearCache(this.numerator, this.denominator);
        setValues(this.numerator, denominator);
    }

    private void setValues(int numerator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("Знаменатель 0");
        }

        int num = numerator;
        int den = denominator;

        if (den < 0) {
            num = -num;
            den = -den;
        }

        this.numerator = num;
        this.denominator = den;
    }

    // Арифметические действия
    public Fraction sum(Fraction other) {
        int newNum = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction minus(Fraction other) {
        int newNum = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction multiply(Fraction other) {
        int newNum = this.numerator * other.numerator;
        int newDen = this.denominator * other.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new RuntimeException("Деление на ноль");
        }
        int newNum = this.numerator * other.denominator;
        int newDen = this.denominator * other.numerator;
        return new Fraction(newNum, newDen);
    }

    @Override
    public String toString() {
        if (denominator == 1)
            return String.valueOf(numerator);

        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
