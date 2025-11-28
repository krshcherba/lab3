package ru.ablaeva.geometry;

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