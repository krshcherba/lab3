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
