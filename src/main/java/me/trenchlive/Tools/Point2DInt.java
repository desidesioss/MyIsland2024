package me.trenchlive.Tools;

import java.util.concurrent.ThreadLocalRandom;

public class Point2DInt {
    private Integer x;
    private Integer y;

    public Point2DInt(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public double distance(Point2DInt other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    public static Point2DInt randomPointInRange(int minX, int minY, int maxX, int maxY) {
        int x = ThreadLocalRandom.current().nextInt(minX, maxX);
        int y = ThreadLocalRandom.current().nextInt(minY, maxY);
        return new Point2DInt(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Переопределение equals и hashCode для корректного сравнения
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2DInt)) return false;
        Point2DInt point = (Point2DInt) o;
        return x.equals(point.x) && y.equals(point.y);
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
