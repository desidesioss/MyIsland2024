package me.trenchlive.AnimalsAndBase.Predators;

import me.trenchlive.AnimalsAndBase.Herbivores.Buffalo;
import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Boa extends Predator {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Boa(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 15;
        MAX_STEP = 1;
        SATURATION_CAPACITY = 3;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Boa(this.XY));
    }

    @Override
    public String toString() {
        return "B";//"🐍";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
