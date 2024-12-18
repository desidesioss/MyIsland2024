package me.trenchlive.AnimalsAndBase.Herbivores;

import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Mouse extends Herbivore {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Mouse(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 0.05;
        MAX_STEP = 1;
        SATURATION_CAPACITY = 0.01;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Mouse(this.XY));
    }

    @Override
    public String toString() {
        return "M";//"🐁";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
