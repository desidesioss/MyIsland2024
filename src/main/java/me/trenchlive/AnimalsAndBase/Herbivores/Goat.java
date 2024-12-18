package me.trenchlive.AnimalsAndBase.Herbivores;

import me.trenchlive.AnimalsAndBase.Entity;
import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Goat extends Herbivore {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Goat(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 60;
        MAX_STEP = 3;
        SATURATION_CAPACITY = 10;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Goat(this.XY));
    }

    @Override
    public String toString() {
        return "G";//"🐐";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
