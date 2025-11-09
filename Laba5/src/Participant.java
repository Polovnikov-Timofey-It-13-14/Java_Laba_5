public class Participant {
    private String lastName;
    private String firstName;
    private int score1;
    private int score2;
    private int score3;
    private int totalScore;

    public Participant(String lastName, String firstName, int score1, int score2, int score3) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.totalScore = score1 + score2 + score3;
    }

    // Геттеры
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getScore3() {
        return score3;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " (" + totalScore + " баллов)";
    }
}