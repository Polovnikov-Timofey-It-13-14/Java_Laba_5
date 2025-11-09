import java.util.*;
import java.util.stream.Collectors;

public class PointSort {
    //Список из точек
    public static Polyline processPoints(List<Point> points) {
        List<Point> processedPoints = points.stream()
                .distinct()                                                     //Удаление дубликатов
                .sorted(Comparator.comparingDouble(Point::getX))                //Сортировка по Х
                .map(point -> {
                    double newY;
                    if (point.getY() < 0) {
                        newY = -point.getY();  // Делаем положительным
                    } else {
                        newY = point.getY();   // Оставляем как есть
                    }
                    return new Point(point.getX(), newY);
                })
                .collect(Collectors.toList());

        return new Polyline(processedPoints);
    }
}