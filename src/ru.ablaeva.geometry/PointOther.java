package ru.ablaeva.geometry;

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