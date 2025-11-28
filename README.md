# Аблаева Карина ИТ-3,4-2024 Лабораторная №3

# Задание 1
## Задача 6
### Отдельные линии
Измените сущность Линия из задачи 1.5.3. Необходимо, чтобы Линия соответствовала 
следующим требованиям: 
• Две любые линии не могут ссылаться на один и тот же объект точки. 
• У Линии можно изменить координаты начала или конца 
• У Линии можно запросить координаты начала или конца 
Продемонстрируйте работоспособность решения на примерах. 
### Алгоритм решения
    public class Line {
    	private Point A;
    	private Point B;

    	// создание линии через 2 точки
    	public Line(Point A, Point B) {
        	this.A = new Point(A.getX(), A.getY());
        	this.B = new Point(B.getX(), B.getY());
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
        	this.A = start; 
    	}

    	public void setEnd(Point end) { 
        	this.B = end; 
    	}

    	// получение длины линии
    	public int getLength() {
        	int dx = B.getX() - A.getX();
        	int dy = B.getY() - B.getY();
        	double lenght = Math.sqrt(dx * dx + dy * dy);
        	return (int) Math.round(lenght);
    	}

    	// вывод текстового представления сущности Линия
    	@Override
    	public String toString() {
        	return "Линия от " + A + " до " + B;
    	}

## Задача 12
### Квадрат
.Создайте сущность Квадрат. Квадрат описывается следующими характеристиками: 
• Имеет Точку (из задачи 1.4.1) отмечающую левый верхний угол 
• Имеет длину стороны. 
• Создается путем указания точки левого верхнего угла и размера стороны 
• Создается путем указания координаты xи y левого верхнего угла и размера стороны 
• Может быть приведен к строке вида “Квадрат в точке T со стороной N”, где N – длина 
стороны, а T – результат приведения к строке верхнего левого угла 
• Может возвращать новую Ломаную (из задачи 1.5.7), точки которой соответствуют 
точкам углов текущего квадрата.   
Необходимо выполнить следующие задачи: 
1. Создайте Квадрат в точке {5;3} со стороной 23 
2. Присвойте в ссылку типа Ломаная результат вызова метода получения Ломаной у ранее 
созданного квадрата 
3. Выведите на экран общую длину полученной Ломаной 
4. Сдвиньте последнюю Точку Ломаной в позицию {15,25} 
5. Снова выведите на экран длину Ломаной
### Алгоритм решения
    public class Square {
    	Point start_point;
    	int side_lenght;

    	public Square (Point start_point, int side_lenght) {
        	this.start_point = start_point;
        	this.side_lenght = side_lenght;
    	}

    	public Square (int x, int y, int side_lenght) {
        	this.start_point = new Point(x, y);
        	this.side_lenght = side_lenght;
    	}

    	@Override
    	public String toString() {
        	return "Квадрат в точке " + start_point + " со стороной " + side_lenght;
    	}
    }

# Задание 2
## Задача 1
### Неизменяемый массив
Необходимо разработать сущность НеизменяемыйСписокЗначений, представляющий собой 
обертку над массивом целых чисел, который сохранит функциональные возможности массивов, 
но добавит некоторые дополнительные возможности. 
Состояние сущности описывают следующие сведения:  
• Имеет массив целых чисел. Именно он используется для хранения значений.  
Инициализация сущности может быть выполнена следующим образом: 
• С указанием значений в виде массива целых чисел. 
• С указанием перечня чисел как независимых значений (через запятую) 
• С указанием другого Списка, в этом случае копируются все значения указанного списка. 
Поведение сущности описывают следующие действия: 
• Получение значения из позицииN. Позиция должна попадать в диапазон от 0 до N-1, где 
N–текущее количество значений, иначе выкинуть ошибку.  
• Замена значения в позиции N на новое значение. Позиция должна попадать в диапазон от 
0 до N-1, где N–текущее количество значений, иначе выкинуть ошибку. 
• Может быть приведен к строке. Строка должна представлять собой полный перечень всех 
хранимых чисел, причем первый символ строки это ”[“, а последний “]”. 
• Можно проверить пуст Список или нет. Список пуст если его размер 0. 
• Можно узнать текущий размер.  
• Все хранящиеся значения можно запросить в виде стандартного массива. 
Продемонстрируйте работоспособность решения на примерах.
### Алгоритм решения
    public class ImmutableListofValues {
    	private int[] arr;
    
    	// Конструктор для массива
     	public ImmutableListofValues(int[] arr) {
        	this.arr = (arr == null) ? new int[0] : arr.clone();
    	}
    
    	// Фабричный метод для независимых значений
    	public static ImmutableListofValues of(int... values) {
        	return new ImmutableListofValues(values);
    	}
    
    	// Конструктор копирования
    	public ImmutableListofValues(ImmutableListofValues other) {
        	this.arr = (other != null && other.arr != null) ? other.arr.clone() : new int[0];
    	}

    	public int[] getArr() {
        	return arr.clone();
    	}

    	public int getValueInN (int n) {
        	int size = this.getLength();
        
        	if (n >= size || n < 0) {
            		throw new ArrayIndexOutOfBoundsException("N не входит в допустимый диапазон-с. Попробуйте снова-с!")
        	}

        	return arr[n];
    	}

    	public int setValueInN (int n, int x) {
        	int size = this.getLength();

        	if (n >= size || n < 0) {
            		throw new ArrayIndexOutOfBoundsException("N не входит в допустимый диапазон-с. Попробуйте снова-с!")
        	}

        	arr[n] = x;
    	}

    	public boolean isNull() {
        	return this.getLength() == 0 ? true : false;
    	}

    	public int getLength() {
        	return arr.length;
    	}

    	@Override
    	public String toString () {
        	String result = "[";
        	int size = this.getLength();

        	for (int i = 0; i < size-2; i++) {
            		result = result + arr[i] + ",";
        	}
        
        	return result + arr[size-1] + "]";
    	}
    }

# Задание 3
## Задача 5
### Трехмерная точка
Создайте такой подвид сущности Точка из задачи 1.1.1, которая будет иметь не две, а три 
координаты на плоскости: X,Y,Z. 
### Алгоритм решения
   public class Point3D extends Point {
    	private int z;

    	public Point3D (int x, int y, int z) {
        	super(x, y);
        	this.z = z;
    	}

    	public int getZ () {
        	return z;
    	}

    	public void setZ (int new_z) {
        	this.z = new_z;
    	}
   }

# Задание 4
## Задача 5
### Точки
Необходимо разработать сущности, которые позволят создавать Точки координат с разными 
характеристиками. Например, мы можем иметь точки координат со следующими 
характеристиками: 
• Одна, две или три координаты в пространстве (X,Y,Z: целые числа) 
• Цвет точки (строка) 
• Время появления точки (строка) 
Обратите внимание, что эти характеристики не составляют исчерпывающий список (так как в 
будущем могут появиться новые характеристики) и могут составлять любые комбинации, 
например:  
• Точка в координате 3, красного цвета 
• Точка в координате {4,2,5} в 11:00 
• Точка в координате {7,7} в 15:35, желтого цвета 
С целью совместимости с последующими задачами, сохраните Двухмерную и Трёхмерную точки 
из задачи 2.3.5 без изменений. 
### Алгоритм решения
     public abstract class PointOther {
    	private int x;
    	private int y;
    	private int z;
    	private String color;
    	private String start_time;

    	public PointOther (int x, String color, String start_time) {
        	this.x = x;
        	this.color = color;
        	this.start_time = start_time;
    	}

    	public PointOther (int x, int y, String color, String start_time) {
        	this.x = x;
        	this.y = y;
        	this.color = color;
        	this.start_time = start_time;
    	}

    	public PointOther (int x, int y, int z, String color, String start_time) {
        	this.x = x;
        	this.y = y;
        	this.z = z;
        	this.color = color;
        	this.start_time = start_time;
    	}
    }

# Задание 5
## Задача 1
### Сложение
Разработайте метод, который принимает набор числовых значенийи возвращает их сумму в 
вещественной форме.
### Алгоритм решения
    class CalculateSum {
    	public double findSum (double ... values) {
        	if (values == null || values.length == 0) {
            		throw new IllegalArgumentException("Количество чисел должно быть больше 0, сударь.");
        	}

        	double result = 0;
        	for (double num : values) {
            		result += num;
        	}

        	return result;
    	}
    }

# Задание 6
## Задача 3
### Сравнение линиий
Измените сущность Линия из задачи 2.1.6.Переопределите метод сравнения объектов по 
состоянию таким образом, чтобы две линии считались одинаковыми в том случае, если их начало 
и конец расположены в одинаковых точках. 
### Алгоритм решения
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line other = (Line) obj;
        return Objects.equals(A, other.A) && Objects.equals(B, other.B);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B);
    }

# Задание 8
## Задача 5
### Сравнение линиий
Измените сущность Линия из 2.6.3.  
Переопределите метод клонирования, унаследованный от класса Object, таким образом, чтобы 
при его вызове возвращался новый объект Линии, значения полей которого будут копиями 
оригинальной Линии.
### Алгоритм решения
    @Override
    public Line clone() {
        try {
            Line cloned_line = (Line) super.clone();
            cloned_line.A = new Point(this.A.getX(), this.B.getY());
            cloned_line.B = new Point(this.B.getX(), this.B.getY());
            return cloned_line;
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }