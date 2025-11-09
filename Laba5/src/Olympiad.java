import java.util.*;

public class Olympiad {
    private Map<Integer, Participant> participants;
    private int maxTotalScore;

    public Olympiad() {
        this.participants = new HashMap<>();
        this.maxTotalScore = 0;
    }

    //Добавить участника
    public void addParticipant(String lastName, String firstName, int score1, int score2, int score3) {
        Participant participant = new Participant(lastName, firstName, score1, score2, score3);
        int newIndex = participants.size();
        participants.put(newIndex, participant);

        if (participant.getTotalScore() > maxTotalScore) {
            maxTotalScore = participant.getTotalScore();
        }
    }

    //Поиск лучшего
    public List<Integer> findBest() {
        List<Integer> bestIndices = new ArrayList<>();
        for (Map.Entry<Integer, Participant> entry : participants.entrySet()) {
            if (entry.getValue().getTotalScore() == maxTotalScore) {
                bestIndices.add(entry.getKey());
            }
        }
        return bestIndices;
    }

    public int getParticipantsCount() {
        return participants.size();
    }

    public int getMaxTotalScore() {
        return maxTotalScore;
    }

    public String getLastName(int index) {
        return participants.get(index).getLastName();
    }

    public String getFirstName(int index) {
        return participants.get(index).getFirstName();
    }

    public int getScore1(int index) {
        return participants.get(index).getScore1();
    }

    public int getScore2(int index) {
        return participants.get(index).getScore2();
    }

    public int getScore3(int index) {
        return participants.get(index).getScore3();
    }

    public int getTotalScore(int index) {
        return participants.get(index).getTotalScore();
    }
}