package me.trenchlive.Generators;

import me.trenchlive.AnimalsAndBase.Herbivores.Plant;
import me.trenchlive.Tools.Point2DInt;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static me.trenchlive.Main.map;

public class PlantSpawner {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public static void init() {
        Runnable spawnTask = () -> {
            map.addEntities(new Plant(Point2DInt.randomPointInRange(0,0, map.getHEIGHT(), map.getWIDTH())));
        };

        scheduler.scheduleAtFixedRate(spawnTask, 0, 1, TimeUnit.SECONDS);
    }
}
