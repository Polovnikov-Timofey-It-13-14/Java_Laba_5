import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Valid valid = new Valid();

        System.out.println("Привет, это 5 лаба по Java");
        String number;
        while (true) {
            System.out.println("Введи номер задания(1-8):");
            System.out.println("9 - Выход");
            number = scanner.nextLine();

            if (!valid.isNumber(number)) {
                System.out.println("Ошибка");
                continue;
            }

            int TaskNum = Integer.parseInt(number);
            if (TaskNum < 1 || TaskNum > 9) {
                System.out.println("Вводимый номер должен быть от 1 до 9");
                continue;
            }

            switch (TaskNum) {
                case 1:
                    System.out.println("1 Задание");

                    System.out.print("Введите числитель: ");
                    String numStr = scanner.nextLine();
                    if (!valid.isInteger(numStr)) {
                        System.out.println("Ошибка: числитель должен быть целым числом");
                        break;
                    }
                    int numerator = Integer.parseInt(numStr);

                    System.out.print("Введите знаменатель: ");
                    String denStr = scanner.nextLine();
                    if (!valid.isInteger(denStr)) {
                        System.out.println("Ошибка: знаменатель должен быть целым числом");
                        break;
                    }
                    int denominator = Integer.parseInt(denStr);

                    if (denominator == 0) {
                        System.out.println("Ошибка: знаменатель не может быть нулем");
                        break;
                    }

                    Fraction fraction = new Fraction(numerator, denominator);
                    System.out.println("Создана дробь: " + fraction);
                    System.out.println("Десятичное значение: " + fraction.getDecimalValue());

                    System.out.println("Изменение дроби:");
                    System.out.print("Введите новый числитель: ");
                    String newNumStr = scanner.nextLine();
                    if (!valid.isInteger(newNumStr)) {
                        System.out.println("Ошибка: числитель должен быть целым числом");
                        break;
                    }
                    int newNumerator = Integer.parseInt(newNumStr);

                    System.out.print("Введите новый знаменатель: ");
                    String newDenStr = scanner.nextLine();
                    if (!valid.isInteger(newDenStr)) {
                        System.out.println("Ошибка: знаменатель должен быть целым числом");
                        break;
                    }
                    int newDenominator = Integer.parseInt(newDenStr);

                    if (newDenominator == 0) {
                        System.out.println("Ошибка: знаменатель не может быть нулем");
                        break;
                    }

                    int oldNumerator = fraction.getNumerator();
                    int oldDenominator = fraction.getDenominator();

                    // Изменяем и числитель, и знаменатель
                    fraction.setNumerator(newNumerator);
                    fraction.setDenominator(newDenominator);
                    System.out.println("Дробь после изменения: " + fraction);

                    System.out.println("Десятичное значение после изменения: " + fraction.getDecimalValue());

                    System.out.println("Демонстрация кэширования двух дробей:");

                    Fraction oldFraction = new Fraction(oldNumerator, oldDenominator);
                    Fraction newFraction = new Fraction(newNumerator, newDenominator);
                    System.out.println("Старая дробь " + oldFraction + ": " + oldFraction.getDecimalValue());
                    System.out.println("Новая дробь " + newFraction + ": " + newFraction.getDecimalValue());

                    break;

                case 2:
                    System.out.println("2 Задание");
                    System.out.print("Введите имя кота: ");
                    String catName = scanner.nextLine();

                    if (catName == null || catName.trim().isEmpty()) {
                        System.out.println("Ошибка: имя кота не может быть пустым");
                        break;
                    }

                    Cat cat = new Cat(catName);
                    System.out.println("Создан: " + cat);
                    CountMeow countMeow = new CountMeow(cat);

                    System.out.println("Вызываем метод:");
                    CatMeow.careForMeowable(countMeow);
                    System.out.println("Кот мяукал " + countMeow.getMeowCount() + " раз");
                    break;

                case 3:
                    System.out.println("3 Задание");
                    ListRemover remover = new ListRemover();

                    System.out.print("Сколько элементов добавить в список? ");
                    String count3Str = scanner.nextLine();
                    if (!valid.isNaturalNumber(count3Str)) {
                        System.out.println("Ошибка: количество должно быть натуральным числом");
                        break;
                    }
                    int count3 = Integer.parseInt(count3Str);

                    List<Object> list = new ArrayList<>();
                    for (int i = 0; i < count3; i++) {
                        System.out.print("Введите элемент " + (i + 1) + ": ");
                        list.add(scanner.nextLine());
                    }

                    System.out.println("Исходный список: " + list);

                    System.out.print("Введите значение для удаления: ");
                    String valueToRemove = scanner.nextLine();

                    List<Object> list1 = new ArrayList<>(list);
                    int removed1 = remover.removeValue(list1, valueToRemove);
                    System.out.println("Удалено элементов: " + removed1);
                    System.out.println("Список после удаления: " + list1);

                //Подстроки
                    /*
                    System.out.print("Введите подстроку для удаления: ");
                    String substring = scanner.nextLine();

                    List<String> list2 = new ArrayList<>(list);
                    int removed2 = remover.removeSubstring(list2, substring);
                    System.out.println("Удалено элементов: " + removed2);
                    System.out.println("Список после удаления: " + list2);

                    List<String> emptyList = new ArrayList<>();
                    int result1 = remover.removeString(emptyList, "test");
                    System.out.println("Пустой список - удалено: " + result1);

                    List<String> listWithNulls = new ArrayList<>(Arrays.asList("one", null, "two"));
                    List<String> listWithNullsCopy = new ArrayList<>(listWithNulls);
                    int result2 = remover.removeString(listWithNullsCopy, null);
                    System.out.println("Список с null - удалено: " + result2);
                    System.out.println("Список после: " + listWithNullsCopy);
                     */

                    break;
                case 4:
                    System.out.println("4 Задание");

                    String filename = "a.txt";
                    Olympiad olympiad = new Olympiad();

                    try {
                        // Читаем все строки из файла
                        List<String> lines = Files.readAllLines(Paths.get(filename));

                        if (lines.isEmpty()) {
                            System.out.println("Файл пуст");
                            return;
                        }

                        // Первая строка - количество участников
                        String firstLine = lines.getFirst().trim();
                        int n;

                        try {
                            n = Integer.parseInt(firstLine);
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка: первая строка должна содержать количество участников");
                            return;
                        }

                        // Проверяем ограничение (1-250 участников)
                        if (n < 1 || n > 250) {
                            System.out.println("Ошибка: количество участников должно быть от 1 до 250");
                            return;
                        }

                        // Проверяем, что в файле достаточно строк
                        if (lines.size() < n + 1) {
                            System.out.println("Ошибка: в файле недостаточно строк данных");
                            return;
                        }

                        // Обрабатываем данные участников
                        int processedCount = 0;

                        for (int i = 1; i <= n && i < lines.size(); i++) {
                            String line = lines.get(i).trim();

                            if (line.isEmpty()) {
                                continue; // Пропускаем пустые строки
                            }

                            String[] parts = line.split("\\s+");

                            // Проверяем формат строки
                            if (parts.length != 5) {
                                System.out.println("Строка " + i + ": неверный формат - " + line);
                                continue;
                            }

                            try {
                                String lastName = parts[0];
                                String firstName = parts[1];
                                int score1 = Integer.parseInt(parts[2]);
                                int score2 = Integer.parseInt(parts[3]);
                                int score3 = Integer.parseInt(parts[4]);

                                // Проверяем диапазон баллов (0-25)
                                if (score1 < 0 || score1 > 25 ||
                                        score2 < 0 || score2 > 25 ||
                                        score3 < 0 || score3 > 25) {
                                    System.out.println("Строка " + i + ": баллы должны быть от 0 до 25 - " + line);
                                    continue;
                                }

                                // Добавляем участника
                                olympiad.addParticipant(lastName, firstName, score1, score2, score3);
                                processedCount++;

                            } catch (NumberFormatException e) {
                                System.out.println("Строка " + i + ": баллы должны быть целыми числами - " + line);
                            }
                        }

                        System.out.println("Максимальный балл: " + olympiad.getMaxTotalScore());
                        System.out.println("Победитель:");

                        String winners = olympiad.getWinners();
                        if (winners.isEmpty()) {
                            System.out.println("Нет победителей");
                        } else {
                            String[] winnerArray = winners.split("\n");
                            for (String winner : winnerArray) {
                                System.out.println("• " + winner);
                            }
                            System.out.println("Всего победителей: " + winnerArray.length);
                        }

                    } catch (IOException e) {
                        System.out.println("Ошибка чтения файла: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Неожиданная ошибка: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("5 Задание");
                    FindLetters findLetters = new FindLetters();

                    String filename5 = "b.txt";

                    try {
                        File file = new File(filename5);
                        if (!file.exists()) {
                            System.out.println("Файл не найден");
                            break;
                        }

                        System.out.println("Чтение файла: " + filename5);

                        Set<Character> uniqueConsonants = findLetters.findConsonants(filename5);

                        if (uniqueConsonants.isEmpty()) {
                            System.out.println("Нет согласных букв, которые входят ровно в одно слово.");
                        } else {
                            System.out.println("Согласные буквы, входящие ровно в одно слово:");
                            for (char consonant : uniqueConsonants) {
                                System.out.print(consonant + " ");
                            }
                            System.out.println();
                            System.out.println("Всего найдено: " + uniqueConsonants.size());
                        }

                    } catch (FileNotFoundException e) {
                        System.out.println("Ошибка: Файл не найден!");
                    } catch (IOException e) {
                        System.out.println("Ошибка при чтении файла: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("6 Задание");
                    Queue<String> queue = new LinkedList<>();

                    System.out.print("Сколько элементов добавить в очередь? ");
                    String count6Str = scanner.nextLine();
                    if (!valid.isPositiveInteger(count6Str)) {
                        System.out.println("Ошибка: количество должно быть неотрицательным целым числом");
                        break;
                    }
                    int count6 = Integer.parseInt(count6Str);

                    System.out.println("Введите элементы очереди:");
                    for (int i = 0; i < count6; i++) {
                        System.out.print("Элемент " + (i + 1) + ": ");
                        queue.add(scanner.nextLine());
                    }

                    System.out.println("Очередь: " + queue);

                    System.out.print("Введите начальный индекс i: ");
                    String iStr = scanner.nextLine();
                    if (!valid.isInteger(iStr)) {
                        System.out.println("Ошибка: индекс должен быть целым числом");
                        break;
                    }
                    int ii = Integer.parseInt(iStr);

                    System.out.print("Введите конечный индекс j: ");
                    String jStr = scanner.nextLine();
                    if (!valid.isInteger(jStr)) {
                        System.out.println("Ошибка: индекс должен быть целым числом");
                        break;
                    }
                    int jj = Integer.parseInt(jStr);

                    int i = ii - 1;
                    int j = jj - 1;

                    try {
                        boolean result = QueueEquals.isSegmentEqual(queue, i, j);
                        System.out.println("Результат: " + result);

                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("7 Задание");
                    List<Point> points = new ArrayList<>();

                    System.out.print("Сколько точек добавить? ");
                    String count7Str = scanner.nextLine();

                    if (!valid.isPositiveInteger(count7Str)) {
                        System.out.println("Ошибка: количество точек должно быть положительным целым числом");
                        break;
                    }
                    int count7 = Integer.parseInt(count7Str);

                    for (int k = 0; k < count7; k++) {
                        System.out.println("Точка " + (k + 1) + ":");

                        double x, y;

                        while (true) {
                            System.out.print("Введите координату X: ");
                            String xStr = scanner.nextLine();
                            try {
                                x = Double.parseDouble(xStr);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: введите корректное число для X");
                            }
                        }

                        while (true) {
                            System.out.print("Введите координату Y: ");
                            String yStr = scanner.nextLine();
                            try {
                                y = Double.parseDouble(yStr);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: введите корректное число для Y");
                            }
                        }

                        points.add(new Point(x, y));
                    }

                    System.out.println("Исходные точки:");
                    for (Point point : points) {
                        System.out.println(point);
                    }

                    Polyline result7 = PointSort.processPoints(points);
                    System.out.println("Результирующая ломаная линия:");
                    System.out.println(result7);
                    break;

                case 8:
                    System.out.println("Задание 8");
                    String filename8 = "c.txt";

                    try {
                        File file = new File(filename8);
                        if (!file.exists()) {
                            System.out.println("Файл не найден!");
                            break;
                        }

                        Map<Integer, List<String>> result8 = StreamSort.processPeopleFile(filename8);

                        System.out.println("Результат группировки:");
                        for (Map.Entry<Integer, List<String>> entry : result8.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }

                    } catch (IOException e) {
                        System.out.println("Ошибка при чтении файла: " + e.getMessage());
                    }
                    break;
            }
        }
    }
}
