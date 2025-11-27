package geometry;

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