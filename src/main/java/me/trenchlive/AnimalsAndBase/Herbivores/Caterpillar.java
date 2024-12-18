package me.trenchlive.AnimalsAndBase.Herbivores;

import me.trenchlive.AnimalsAndBase.Entity;
import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Caterpillar extends Herbivore {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Caterpillar(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 0.01;
        MAX_STEP = 0;
        SATURATION_CAPACITY = 0;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Caterpillar(this.XY));
    }

    @Override
    public String toString() {
        return "C";//"🐛";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
