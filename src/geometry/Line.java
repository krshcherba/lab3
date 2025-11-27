package geometry;

import java.util.Objects;

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
}
