package ru.ablaeva.geometry;

public abstract class PointOther {
    protected int x;
    protected int y;
    protected int z;
    protected String color;
    protected String start_time;

    // Конструкторы protected - чтобы могли использовать только наследники
    protected PointOther(int x, String color, String start_time) {
        this.x = x;
        this.color = color;
        this.start_time = start_time;
    }

    protected PointOther(int x, int y, String color, String start_time) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.start_time = start_time;
    }

    protected PointOther(int x, int y, int z, String color, String start_time) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
        this.start_time = start_time;
    }

    // Геттеры
    public int getX() { return x; }
    public int getY() { return y; }
    public int getZ() { return z; }
    public String getColor() { return color; }
    public String getStartTime() { return start_time; }

    // Абстрактный метод (опционально)
    public abstract String getDescription();
}