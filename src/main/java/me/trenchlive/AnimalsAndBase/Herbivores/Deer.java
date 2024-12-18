package me.trenchlive.AnimalsAndBase.Herbivores;

import me.trenchlive.AnimalsAndBase.Entity;
import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Deer extends Herbivore {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Deer(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 300;
        MAX_STEP = 4;
        SATURATION_CAPACITY = 50;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Deer(this.XY));
    }

    @Override
    public String toString() {
        return "D";//"D";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
