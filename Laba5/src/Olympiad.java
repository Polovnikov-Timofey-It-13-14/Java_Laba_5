import java.nio.file.*;
import java.util.*;

public class Olympiad {
    private String bestLastName;
    private String bestFirstName;
    private int bestScore1;
    private int bestScore2;
    private int bestScore3;
    private int bestTotalScore;
    private String winnersList;

    // Конструктор
    public Olympiad() {
        this.bestTotalScore = 0;
        this.winnersList = "";
    }

    // Метод для добавления участника и обновления информации о победителях
    public void addParticipant(String lastName, String firstName, int score1, int score2, int score3) {
        int totalScore = calculateTotalScore(score1, score2, score3);

        // Если это первый участник или у него больше баллов, чем у текущего лучшего
        if (totalScore > bestTotalScore) {
            // Обновляем данные лучшего участника
            bestLastName = lastName;
            bestFirstName = firstName;
            bestScore1 = score1;
            bestScore2 = score2;
            bestScore3 = score3;
            bestTotalScore = totalScore;

            // Начинаем новый список победителей
            winnersList = lastName + " " + firstName + "\n";
        }
        // Если у участника столько же баллов, как у лучшего
        else if (totalScore == bestTotalScore) {
            // Добавляем его к списку победителей
            winnersList += lastName + " " + firstName + "\n";
        }
    }

    // Метод для вычисления общей суммы баллов
    public int calculateTotalScore(int score1, int score2, int score3) {
        return score1 + score2 + score3;
    }
}
