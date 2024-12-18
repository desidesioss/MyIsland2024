package me.trenchlive.AnimalsAndBase.Predators;

import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Wolf extends Predator {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Wolf(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 50;
        MAX_STEP = 3;
        SATURATION_CAPACITY = 8;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Wolf(this.XY));
    }

    @Override
    public String toString() {
        return "W";//"🐺";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
