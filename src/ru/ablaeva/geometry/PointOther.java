package ru.ablaeva.geometry;

public abstract class PointOther {
    protected int x;
    protected int y;
    protected int z;
    protected String color;
    protected String start_time;

    protected PointOther(int x, String color, String start_time) {
        this.x = x;
        this.y = 0;
        this.z = 0;
        this.color = color;
        this.start_time = start_time;
    }

    protected PointOther(int x, int y, String color, String start_time) {
        this.x = x;
        this.y = y;
        this.z = 0;
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
    public int getX() { 
        return x; 
    }

    public int getY() { 
        return y; 
    }

    public int getZ() { 
        return z; 
    }

    public String getColor() { 
        return color; 
    }

    public String getStartTime() { 
        return start_time; 
    }

    // Сеттеры
    public void setX(int x) { 
        this.x = x; 
    }

    public void setY(int y) { 
        this.y = y; 
    }

    public void setZ(int z) { 
        this.z = z; 
    }

    public void setColor(String color) { 
        this.color = color; 
    }

    public void setStartTime(String start_time) { 
        this.start_time = start_time; 
    }

    // Абстрактный метод
    public abstract String getDescription();

    // Вложенные классы
    public static class Point1D extends PointOther {
        public Point1D(int x, String color, String start_time) {
            super(x, color, start_time);
        }

        @Override
        public String getDescription() {
            return "Одномерная точка";
        }

        @Override
        public String toString() {
            return "Точка{" + x + "} цвет: " + color + " время: " + start_time;
        }
    }

    public static class Point2D extends PointOther {
        public Point2D(int x, int y, String color, String start_time) {
            super(x, y, color, start_time);
        }

        @Override
        public String getDescription() {
            return "Двумерная точка";
        }

        @Override
        public String toString() {
            return "Точка{" + x + "," + y + "} цвет: " + color + " время: " + start_time;
        }
    }

    public static class Point3DWithProps extends PointOther {
        public Point3DWithProps(int x, int y, int z, String color, String start_time) {
            super(x, y, z, color, start_time);
        }

        @Override
        public String getDescription() {
            return "Трехмерная точка с характеристиками";
        }

        @Override
        public String toString() {
            return "Точка{" + x + "," + y + "," + z + "} цвет: " + color + " время: " + start_time;
        }
    }
}