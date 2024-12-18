package me.trenchlive.AnimalsAndBase.Herbivores;

import me.trenchlive.AnimalsAndBase.Entity;
import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Duck extends Herbivore {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Duck(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 1;
        MAX_STEP = 4;
        SATURATION_CAPACITY = 0.15;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Duck(this.XY));
    }

    @Override
    public String toString() {
        return "D";//"🦆";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
