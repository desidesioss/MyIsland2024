package me.trenchlive.AnimalsAndBase.Predators;

import me.trenchlive.AnimalsAndBase.Herbivores.Buffalo;
import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Fox extends Predator {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Fox(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 8;
        MAX_STEP = 2;
        SATURATION_CAPACITY = 2;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Fox(this.XY));
    }

    @Override
    public String toString() {
        return "F";//"🦊";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
