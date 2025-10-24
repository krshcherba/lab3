# Аблаева Карина ИТ-3,4-2024 Лабораторная №2

# Задание 1
## Задача 1
### Точка координат
Создайте	сущность	Точка,	расположенную	на	двумерной	плоскости,	которая	описывается:
• Координата	Х:	число
• Координата	Y:	число
• Может	возвращать	текстовое	представление	вида	“{X;Y}”
Необходимо	 создать	 три	 точки	 с	 разными	 координатами	 и	 вывести	 на	 экран	 их	 текстовое	
представление.
### Алгоритм решения
    public class Point {
        private int x;
        private int y;
    
        // создание точки
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    
        // получение координаты х
        public int getX() {
            return x;
        }
    
        // получение координаты y
        public int getY() {
            return y;
        }
    
        // изменение координаты x
        public void setX(int x) {
            this.x = x;
        }
    
        // изменение координаты y
        public void setY(int y) {
            this.y = y;
        }
    
        // вывод текствого представления сущности Точка
        @Override
        public String toString() {
            return "{" + x + "," + y + "}";
        }
    }
    
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
        }
    }

# Задание 2
## Задача 1
### Прямая
Создайте сущность Линия, расположенную на двумерной плоскости, которая описывается:
• Координата начала: Точка
• Координата конца: Точка
• Может возвращать текстовое представление вида “Линия от {X1;Y1} до {X2;Y2}”
Для указания координат нужно использовать сущность Точка, разработанную в задании 1.1. Создайте
линии со следующими характеристиками:
1. Линия 1 с началом в т. {1;3} и концом в т.{23;8}.
2. Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25.
3. Линия 3, которая начинается всегда там же, где начинается линия 1, и заканчивается всегда там
же, где заканчивается линия 2. Таким образом, если положение первой или второй линии
меняется, то меняется и третья линия.
4. После создания всех трех объектов измените координаты первой и второй линий, причем
сделайте это таким образом, чтобы положение третьей линии соответствовало требованиям
пункта 3.
5. Измените координаты первой линии так, чтобы при этом не изменились, координаты третьей
линии.
### Алгоритм решения
    public class App {
        public static void main(String[] args) throws Exception {
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
    }

# Задание 3
## Задача 1
### Студент
Студент.	
Создайте	сущность	Студент,	которая	описывается:
• Имя:	строка
• Оценки:	массив	целых	чисел.
• Может	возвращать	текстовое	представление	вида	“Имя:	[оценка1,	оценка2,…,оценкаN]”
Необходимо	выполнить	следующие	задачи:
1. Создать	студента	Васю	с	оценками:	3,4,5.	
2. Создать	 студента	 Петю	 и	 скопировать	 оценки	 Васи,	 присвоив	 содержимое	 поля	 с	
оценками	Васи	полю	с	оценками	Пети.	
3. Заменить	 первую	 оценку	 Пети	 на	 число	 5.	 Вывести	 на	 экран	 строковое	 представление	
Васи	и	Пети.	Объяснить	результат
4. Создать	 студента	 Андрея	 и	 скопировать	 ему	 оценки	 Васи	 так,	 чтобы	 изменение	 оценок	
Васи	не	влияло	на	Андрея.
### Алгоритм решения
    public class Student {
        private String studentName;
        private int[] marks;
        private Student() {}
    
        // создание студента
        public Student(String studentName, int[] marks) {
            this();
            this.studentName = studentName;
            this.marks = marks;
        }
    
        // получение оценок студента
        public int[] getMarks() {
            return marks;
        }
    
        // копирование оценок студента
        public static int[] copyMarks(int[] original) {
            return original != null ? original.clone() : null;
        }
    
        // вывод текстового представления сущности Студент
        @Override
        public String toString() {
            String result = studentName + ": ";
            for(int i = 0; i < marks.length; i++) {
                if (i == marks.length - 1) {
                    result = result + marks[i];
                }
                else {
                    result = result + marks[i] + ", ";
                }
            }
            return result;
        }
    }
    
    public class App {
        public static void main(String[] args) throws Exception {
            System.out.println("\nРабота с классом Student");
    
            int[] vasyaMarks = {3, 4, 5};
            Student vasya = new Student("Вася", vasyaMarks);
    
            Student petya = new Student("Петя", vasyaMarks); // та же ссылка
    
            petya.getMarks()[0] = 5;
            vasyaMarks[0] = 5;
    
            System.out.println("\nПосле изменения первой оценки у Пети (через общий массив):");
            System.out.println(vasya);
            System.out.println(petya);
            System.out.println("Оценки изменились у обоих, потому что массив общий.");
    
            int[] andreyMarks = Student.copyMarks(new int[]{3, 4, 5}); // исходные оценки Васи до изменения
            // Но Вася уже изменён... поэтому сохраним исходные отдельно
            int[] originalVasya = {3, 4, 5};
            vasya = new Student("Вася", originalVasya);
            petya = new Student("Петя", originalVasya);
            petya.getMarks()[0] = 5;
    
            // Пересоздаём:
            originalVasya = new int[]{3, 4, 5};
            vasya = new Student("Вася", originalVasya);
            petya = new Student("Петя", vasya.getMarks());
            petya.getMarks()[0] = 5;
    
            Student andrey = new Student("Андрей", Student.copyMarks(originalVasya));
    
            System.out.println("\nФинальный результат:");
            System.out.println(vasya);
            System.out.println(petya);
            System.out.println(andrey);
            System.out.println("У Андрея оценки не изменились, потому что массив скопирован.");
        }
    }

# Задание 4
## Задача 1
### Создаем точку
Измените	сущность	Точка	из	задачи	1.1.	В	соответствии	с	новыми	требованиями	создать	объект	
Точки	можно	только	путем	указания	обеих	координат:X и	Y.	
Необходимо	выполнить	следующие	задачи:
• Создайте	и	выведите	на	экран	точку	с	координатами	3;5
• Создайте	и	выведите	на	экран	точку	с	координатами	25;6
• Создайте	и	выведите	на	экран	точку	с	координатами	7;8
### Алгоритм решения
См. Задание 1.1

## Задача 2
### Создаем линию
Измените	сущность	Линия	из	задачи	2.1.	Новые	требования	включают:
• Создание	Линии	возможно	с	указанием	Точки	начала	и	Точки	конца	(Точки	из	задачи	4.1)
• Создание	 Линии	 возможно	 с	 указанием	 координат	 начала	 и	 конца	 как	 четырех	 чисел	
(x1,y1,x2,y2)
Создайте	линии	со	следующими	характеристиками:
1. Линия	1	с	началом	в	т.	{1;3} и	концом	в	{23;8}.
2. Линия	2,	горизонтальная,	на	высоте	10,	от	точки	5	до	точки	25.
3. Линия	 3	 которая	 начинается	 всегда	 там	 же	 где	 начинается	 линия	 1,	 и	 заканчивается	
всегда	там	же,	где	заканчивается	линия	2.
### Алгоритм решения
См. Задание 2.1

# Задание 5
## Задача 3
### Длина линии
Измените	 сущность	 Линия	 из	 задачи	 4.2.	 Добавьте	 ей	 возможность	 возвращать	 по	 запросу	
пользователя	расстояние	между	точками	начала	и	конца	(в	виде	целого	числа).	Создайте	линию	
из	точки	{1;1}	в	точку	{10;15}	и	выведите	на	экран	её	длину.
### Алгоритм решения
    public class Line {
        private Point A;
        private Point B;
    
        // создание линии через 2 точки
        public Line(Point A, Point B) {
            // if (A == null || B == null) {
            //     throw new IllegalArgumentException("Точки не могут быть null");
            // }
            this.A = A;
            this.B = B;
        }
    
        // создание линии через 4 координаты
        public Line(int x1, int y1, int x2, int y2) {
            this(new Point(x1, y1), new Point(x2, y2));
        }
    
        // получение точек начала A и конца B линии
        public Point getStart() { 
            return A; 
        }
    
        public Point getEnd() { 
            return B; 
        } 
    
        // изменение координат точек
        public void setStart(Point start) { 
            this.A = A; 
        }
    
        public void setEnd(Point end) { 
            this.B = B; 
        }
    
        // получение длины линии
        public int getLength() {
            int dx = B.getX() - A.getX();
            int dy = B.getY() - B.getY();
            double lenght = Math.sqrt(dx ^ 2 + dy ^ 2);
            return (int) Math.round(lenght);
        }
    
        // вывод текстового представления сущности Линия
        @Override
        public String toString() {
            return "Линия от " + A + " до " + B;
        }
    }
    
    public class App {
        public static void main(String[] args) throws Exception {
            // Длина линии
            Line testLine = new Line(1, 1, 10, 15);
            System.out.println("\nДлина линии от {1;1} до {10;15}: " + testLine.getLength());
        }
    }
