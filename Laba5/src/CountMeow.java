public class CountMeow implements Meowable {
    private final Cat cat;
    private int meowCount;

    public CountMeow(Cat cat) {
        this.cat = cat;
        this.meowCount = 0;
    }

    @Override
    public void meow() {
        cat.meow();
        meowCount++;                        //Декоратор для подсчета
    }

    public int getMeowCount() {
        return meowCount;
    }

    @Override
    public String toString() {
        return cat.toString();
    }
}