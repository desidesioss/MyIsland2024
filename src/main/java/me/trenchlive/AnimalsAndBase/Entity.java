package me.trenchlive.AnimalsAndBase;

import me.trenchlive.Tools.Point2DInt;

public class Entity {
    protected volatile Point2DInt XY;
    protected volatile double WEIGHT;
    protected volatile boolean DEAD;

    public Entity(Point2DInt _xy) {
        XY = _xy;
        DEAD = false;
    }
}
