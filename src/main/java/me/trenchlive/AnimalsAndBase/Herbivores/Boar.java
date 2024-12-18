package me.trenchlive.AnimalsAndBase.Herbivores;

import me.trenchlive.AnimalsAndBase.Entity;
import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Boar extends Herbivore {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Boar(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 400;
        MAX_STEP = 2;
        SATURATION_CAPACITY = 50;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Boar(this.XY));
    }

    @Override
    public String toString() {
        return "B";//"🐗";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
