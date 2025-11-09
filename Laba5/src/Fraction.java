import java.util.Objects;

public final class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;
    private Double cachedValue;
    private boolean isCached;

    //Конструкторы
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

    public Fraction(double den) {
        this((int)(den * 10), 10);
    }

    // Геттеры
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double getDecimalValue() {
        if (!isCached || cachedValue == null) {
            cachedValue = (double) numerator / denominator;
            isCached = true;
        }
        return cachedValue;
    }

    //Сеттеры
    public void setNumerator(int numerator) {
        setValues(numerator, this.denominator);
    }

    public void setDenominator(int denominator) {
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
        invalidateCache();
    }

    //Сбрасывание кэша
    private void invalidateCache() {
        isCached = false;
        cachedValue = null;
    }

    //Арифметические действия
    public Fraction sum(Fraction x) {
        int newNum = this.numerator * x.denominator + x.numerator * this.denominator;
        int newDen = this.denominator * x.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction sum(double num) {
        return sum(new Fraction(num));
    }

    public Fraction minus(Fraction x) {
        int newNum = this.numerator * x.denominator - x.numerator * this.denominator;
        int newDen = this.denominator * x.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction minus(int num) {
        return minus(new Fraction(num));
    }

    public Fraction multiply(Fraction x) {
        int newNum = this.numerator * x.numerator;
        int newDen = this.denominator * x.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction multiply(int num) {
        return multiply(new Fraction(num));
    }

    public Fraction divide(Fraction x) {
        if (x.denominator == 0) {
            throw new RuntimeException("Знаменатель 0");
        }
        int newNum = this.numerator * x.denominator;
        int newDen = this.denominator * x.numerator;
        return new Fraction(newNum, newDen);
    }

    public Fraction divide(int num) {
        if (num == 0){
            throw new RuntimeException("Знаменатель 0");
        }
        return divide(new Fraction(num));
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