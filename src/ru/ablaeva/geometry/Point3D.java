package ru.ablaeva.geometry;

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

    @Override
    public String toString () {
        return "{" + getX() + "," + getY() + "," + z + "}";
    }
}
