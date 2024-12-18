package me.trenchlive.AnimalsAndBase.Herbivores;

import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Sheep extends Herbivore {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Sheep(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 70;
        MAX_STEP = 3;
        SATURATION_CAPACITY = 15;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Sheep(this.XY));
    }

    @Override
    public String toString() {
        return "S";//""🐑";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
