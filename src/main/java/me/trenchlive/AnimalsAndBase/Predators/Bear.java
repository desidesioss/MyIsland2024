package me.trenchlive.AnimalsAndBase.Predators;

import me.trenchlive.AnimalsAndBase.Herbivores.Buffalo;
import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Bear extends Predator {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Bear(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 500;
        MAX_STEP = 2;
        SATURATION_CAPACITY = 80;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Bear(this.XY));
    }

    @Override
    public String toString() {
        return "B";//"🐻";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
