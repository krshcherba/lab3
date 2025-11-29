package ru.ablaeva.main;

import ru.ablaeva.geometry.*;
import ru.ablaeva.arithmetic.*;
import ru.ablaeva.list.*;
import ru.ablaeva.list.ImmutableListofValues;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Лабораторная работа №3 ===");
        System.out.println("Аблаева Карина ИТ-3,4-2024");
        
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = readInt("Выберите задание: ");
            
            switch (choice) {
            case 1:
                demonstrateTask1();
                break;
            case 2:
                demonstrateTask2();
                break;
            case 3: 
                demonstrateTask3();
                break;
            case 4:
                demonstrateTask4();
                break;
            case 5:
                demonstrateTask5();
                break;
            case 6:
                demonstrateTask6();
                break;
            case 7:
                demonstrateTask7();
                break;
            case 0:
                exit = true;
                break;
            default:
                System.out.println("Неверный выбор-с! Попробуйте снова-с.");
                break;
        }
        }
        
        scanner.close();
        System.out.println("Программа завершена-c. До свидания-c!");
    }

    private static void printMenu() {
        System.out.println("\n=== Главное меню ===");
        System.out.println("1 - Задание 1: Линия и Квадрат");
        System.out.println("2 - Задание 2: Неизменяемый массив");
        System.out.println("3 - Задание 3: Трехмерная точка");
        System.out.println("4 - Задание 4: Точки с характеристиками");
        System.out.println("5 - Задание 5: Сложение чисел");
        System.out.println("6 - Задание 6: Сравнение линий");
        System.out.println("7 - Задание 7: Клонирование линий");
        // System.out.println("8 - Задание 8: Возведение в степень");
        System.out.println("0 - Выход");
    }

        // Задание 1: Линия и Квадрат
    private static void demonstrateTask1() {
        System.out.println("\n=== Задание 1: Линия и Квадрат ===");
        
        // Демонстрация Линии
        System.out.println("\n--- Линия ---");
        Point p1 = new Point(readInt("Введите x1: "), readInt("Введите y1: "));
        Point p2 = new Point(readInt("Введите x2: "), readInt("Введите y2: "));
        
        Line line = new Line(p1, p2);
        System.out.println("Создана: " + line);
        System.out.println("Длина линии: " + line.getLength());
        
        // Изменение координат
        Point newStart = new Point(readInt("Введите новый x начала: "), readInt("Введите новый y начала: "));
        line.setStart(newStart);
        System.out.println("После изменения начала: " + line);
        
        // Демонстрация Квадрата
        System.out.println("\n--- Квадрат ---");
        Point squarePoint = new Point(readInt("Введите x верхнего левого угла: "), readInt("Введите y верхнего левого угла: "));
        int side = readInt("Введите длину стороны: ");
        
        Square square = new Square(squarePoint, side);
        System.out.println("Создан: " + square);
    }

    // Задание 2: Неизменяемый массив
    private static void demonstrateTask2() {
        System.out.println("\n=== Задание 2: Неизменяемый массив ===");
        
        System.out.println("Создание массива через фабричный метод:");
        ImmutableListofValues list1 = ImmutableListofValues.of(1, 2, 3, 4, 5);
        System.out.println("list1: " + list1);
        
        System.out.println("Создание копии массива:");
        ImmutableListofValues list2 = new ImmutableListofValues(list1);
        System.out.println("list2: " + list2);
        
        System.out.println("Пустой массив: []");
        ImmutableListofValues emptyList = ImmutableListofValues.of();
        System.out.println("Пуст ли массив? " + emptyList.isNull());
        
        // Получение значения по индексу
        int index = readInt("Введите индекс для получения значения (0-" + (list1.getLength()-1) + "): ");
        try {
            int value = list1.getValueInN(index);
            System.out.println("Значение в позиции " + index + ": " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Замена значения по индексу
        index = readInt("Введите индекс для замены значения (0-" + (list1.getLength()-1) + "): ");
        int value = readInt("Введите значение: ");
        try {
            list1.setValueInN(index, value);
            System.out.println("Значение в позиции " + index + ": " + list1.getArr()[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        
        System.out.println("Размер list1: " + list1.getLength());
    }

    // Задание 3: Трехмерная точка
    private static void demonstrateTask3() {
        System.out.println("\n=== Задание 3: Трехмерная точка ===");
        
        int x = readInt("Введите x: ");
        int y = readInt("Введите y: ");
        int z = readInt("Введите z: ");
        
        Point3D point3D = new Point3D(x, y, z);
        System.out.println("Создана: " + point3D);
        System.out.println("Координаты: x=" + point3D.getX() + ", y=" + point3D.getY() + ", z=" + point3D.getZ());
        
        // Изменение координаты Z
        int newZ = readInt("Введите новое значение z: ");
        point3D.setZ(newZ);
        System.out.println("После изменения z: " + point3D);
    }

    // Задание 4: Точки с характеристиками
    private static void demonstrateTask4() {
        System.out.println("\n=== Задание 4: Точки с характеристиками ===");
        
        System.out.println("Создание точки с одной координатой:");
        PointOther point1 = new PointOther.Point1D (
            readInt("Введите x: "),
            readString("Введите цвет: "),
            readString("Введите время: ")
        );
        
        System.out.println("Создание точки с двумя координатами:");
        PointOther point2 = new PointOther.Point2D (
            readInt("Введите x: "),
            readInt("Введите y: "),
            readString("Введите цвет: "),
            readString("Введите время: ")
        );
        
        System.out.println("Создание точки с тремя координатами:");
        PointOther point3 = new PointOther.Point3DWithProps (
            readInt("Введите x: "),
            readInt("Введите y: "),
            readInt("Введите z: "),
            readString("Введите цвет: "),
            readString("Введите время: ")
        );
        
        System.out.println("\nСозданные точки:");
        System.out.println("Точка 1: " + point1);
        System.out.println("Точка 2: " + point2);
        System.out.println("Точка 3: " + point3);
    }

    // Задание 5: Сложение чисел
    private static void demonstrateTask5() {
        System.out.println("\n=== Задание 5: Сложение чисел ===");
        
        CalculateSum calculator = new CalculateSum();
        
        System.out.println("Введите количество чисел для сложения:");
        int count = readInt("Количество: ");
        
        if (count <= 0) {
            System.out.println("Количество чисел должно быть положительным!");
            return;
        }
        
        double[] numbers = new double[count];
        for (int i = 0; i < count; i++) {
            int choice = readInt("В каком ввиде будет вводиться значение? 1 - вещественное число, 2 - обыкновенная дробь: ");
            switch (choice) {
                case 1:
                    numbers[i] = readDouble("Введите число " + (i + 1) + ": ");
                    break;
                case 2: 
                    String input = readString("Введите дробь в формате n/m: ");
                    String[] parts = input.split("/");
                    if (parts.length == 2) {
                        double num = Double.parseDouble(parts[0]);
                        double den = Double.parseDouble(parts[1]);
                        numbers[i] = num / den; // 0.6
                    }
                    break;
            }
        }
        
        try {
            double sum = calculator.findSum(numbers);
            System.out.println("Сумма чисел: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Задание 6: Сравнение линий
    private static void demonstrateTask6() {
        System.out.println("\n=== Задание 6: Сравнение линий ===");
        
        System.out.println("Создание первой линии:");
        Point p1 = new Point(readInt("Введите x1: "), readInt("Введите y1: "));
        Point p2 = new Point(readInt("Введите x2: "), readInt("Введите y2: "));
        Line line1 = new Line(p1, p2);
        
        System.out.println("Создание второй линии:");
        Point p3 = new Point(readInt("Введите x1: "), readInt("Введите y1: "));
        Point p4 = new Point(readInt("Введите x2: "), readInt("Введите y2: "));
        Line line2 = new Line(p3, p4);
        
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линии равны? " + line1.equals(line2));
        
        // Создание идентичной линии для демонстрации
        Line line3 = new Line(new Point(p1.getX(), p1.getY()), new Point(p2.getX(), p2.getY()));
        System.out.println("Линия 3 (копия линии 1): " + line3);
        System.out.println("Линия 1 и Линия 3 равны? " + line1.equals(line3));
    }

    // Задание 7: Клонирование линий
    private static void demonstrateTask7() {
        System.out.println("\n=== Задание 7: Клонирование линий ===");
        
        Point p1 = new Point(readInt("Введите x1: "), readInt("Введите y1: "));
        Point p2 = new Point(readInt("Введите x2: "), readInt("Введите y2: "));
        Line originalLine = new Line(p1, p2);
        
        System.out.println("Оригинальная линия: " + originalLine);
        
        try {
            Line clonedLine = originalLine.clone();
            System.out.println("Клонированная линия: " + clonedLine);
            System.out.println("Это один и тот же объект? " + (originalLine == clonedLine));
            System.out.println("Объекты равны по содержанию? " + originalLine.equals(clonedLine));
            
            // Изменяем клон и проверяем, что оригинал не изменился
            Point newPoint = new Point(100, 100);
            clonedLine.setStart(newPoint);
            System.out.println("После изменения клона:");
            System.out.println("Оригинал: " + originalLine);
            System.out.println("Клон: " + clonedLine);
            
        } catch (RuntimeException e) {
            System.out.println("Ошибка при клонировании: " + e.getMessage());
        }
    }

    // Вспомогательные методы для ввода с проверкой
    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите число.");
            }
        }
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}