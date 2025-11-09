import java.util.*;

public class QueueEquals {
    //Сравнение элементов очереди
    public static <T> boolean isSegmentEqual(Queue<T> queue, int i, int j) {
        if (queue == null || queue.isEmpty()) {
            throw new IllegalArgumentException("Очередь не может быть пустой");
        }
        if (i < 0 || j >= queue.size() || i >= j) {
            throw new IllegalArgumentException("Неверные индексы i и j");
        }

        Queue<T> copy = new LinkedList<>(queue);                            //Двусвязный список

        for (int k = 0; k < i; k++) {
            copy.poll();
        }

        T firstElement = copy.poll();                                       //1 элемент

        for (int k = i + 1; k <= j; k++) {
            T current = copy.poll();
            if (!Objects.equals(current, firstElement)) {
                return false;
            }
        }
        return true;
    }
}
