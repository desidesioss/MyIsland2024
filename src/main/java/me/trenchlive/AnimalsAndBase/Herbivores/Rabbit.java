package me.trenchlive.AnimalsAndBase.Herbivores;

import me.trenchlive.Tools.Point2DInt;

import java.util.HashMap;

import static me.trenchlive.Main.map;

public class Rabbit extends Herbivore {
    public static HashMap<Class<?>, Integer> IEat = new HashMap<>();
    public Rabbit(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 2;
        MAX_STEP = 2;
        SATURATION_CAPACITY = 0.45;
    }

    @Override
    protected void reproduce() {
        map.addEntities(new Rabbit(this.XY));
    }

    @Override
    public String toString() {
        return "R";//"🐇";
    }

    @Override
    public HashMap<Class<?>, Integer> getIEat() {
        return IEat;
    }
}
