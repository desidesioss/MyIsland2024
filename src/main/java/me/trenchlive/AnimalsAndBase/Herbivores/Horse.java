package me.trenchlive.AnimalsAndBase.Herbivores;

import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Horse extends Herbivore {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Horse(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 400;
        MAX_STEP = 4;
        SATURATION_CAPACITY = 60;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Horse(this.XY));
    }

    @Override
    public String toString() {
        return "H";//"🐎";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
