package me.trenchlive.AnimalsAndBase.Predators;

import me.trenchlive.AnimalsAndBase.Herbivores.Buffalo;
import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Eagle extends Predator {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Eagle(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 6;
        MAX_STEP = 3;
        SATURATION_CAPACITY = 1;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Eagle(this.XY));
    }

    @Override
    public String toString() {
        return "E";//"🦅";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
