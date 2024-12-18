package me.trenchlive.AnimalsAndBase.Herbivores;

import me.trenchlive.AnimalsAndBase.Entity;
import me.trenchlive.Tools.Point2DInt;

public class Plant extends Entity {
    public Plant(Point2DInt _xy) {
        super(_xy);
        WEIGHT = 1;
    }

    public String toString() {
        return "+";//"G";
    }
}
