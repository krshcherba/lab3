public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Работа с классом Point");
        // Задание 1
        Point p1 = new Point(3, 5);
        Point p2 = new Point(25, 6);
        Point p3 = new Point(7, 8);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("\nРабота с классом Line");
        // Линия 1: {1;3} -> {23;8}
        Point start1 = new Point(1, 3);
        Point end1 = new Point(23, 8);
        Line line1 = new Line(start1, end1);

        // Линия 2: горизонтальная на y=10, от x=5 до x=25
        Point start2 = new Point(5, 10);
        Point end2 = new Point(25, 10);
        Line line2 = new Line(start2, end2);

        // Линия 3: начало = начало line1, конец = конец line2
        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("Исходные линии:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        // Пункт 4: изменить line1 и line2 так, чтобы line3 изменилась
        System.out.println("\nИзменяем координаты точек (не заменяя объекты)...");
        line1.getStart().setX(100);
        line1.getStart().setY(200);
        line2.getEnd().setX(300);
        line2.getEnd().setY(400);

        System.out.println("После изменения координат:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println("Линия 3 (должна измениться): " + line3);

        // Пункт 5: изменить line1 так, чтобы line3 НЕ изменилась
        System.out.println("\nТеперь заменяем точку начала line1 на НОВУЮ...");
        line1.setStart(new Point(999, 888));
        System.out.println("Line1 после замены точки: " + line1);
        System.out.println("Line3 (должна остаться прежней): " + line3);

        // Длина линии
        Line testLine = new Line(1, 1, 10, 15);
        System.out.println("\nДлина линии от {1;1} до {10;15}: " + testLine.getLength());

        System.out.println("\nРабота с классом Student");

        int[] vasyaMarks = {3, 4, 5};
        Student vasya = new Student("Вася", vasyaMarks);

        Student petya = new Student("Петя", vasyaMarks); // та же ссылка

        petya.getMarks()[0] = 5;
        //vasyaMarks[0] = 5;

        System.out.println("\nПосле изменения первой оценки у Пети (через общий массив):");
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println("Оценки изменились у обоих, потому что массив общий.");

        int[] andreyMarks = Student.copyMarks(new int[]{3, 4, 5}); // исходные оценки Васи до изменения

        int[] originalVasya = {3, 4, 5};
        vasya = new Student("Вася", originalVasya);
        petya = new Student("Петя", originalVasya);
        petya.getMarks()[0] = 5;

        // Пересоздаём:
        originalVasya = new int[]{3, 4, 5};
        vasya = new Student("Вася", originalVasya);
        petya = new Student("Петя", vasya.getMarks());

        Student andrey = new Student("Андрей", Student.copyMarks(originalVasya));
        petya.getMarks()[0] = 5;

        System.out.println("\nФинальный результат:");
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println(andrey);
        System.out.println("У Андрея оценки не изменились, потому что массив скопирован.");
    }
}
