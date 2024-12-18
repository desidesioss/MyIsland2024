package me.trenchlive.AnimalsAndBase.Herbivores;

import me.trenchlive.AnimalsAndBase.Entity;
import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Buffalo extends Herbivore {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Buffalo(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 700;
        MAX_STEP = 3;
        SATURATION_CAPACITY = 100;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Buffalo(this.XY));
    }

    @Override
    public String toString() {
        return "B";//"🐃";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
