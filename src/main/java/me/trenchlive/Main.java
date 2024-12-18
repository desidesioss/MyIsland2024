package me.trenchlive;

import me.trenchlive.AnimalsAndBase.EdibilityTable;
import me.trenchlive.Generators.AnimalGenerator;
import me.trenchlive.Generators.PlantSpawner;
import me.trenchlive.LandscapeAndMap.Map;
import me.trenchlive.Logging.Logging;
import me.trenchlive.Visuals.DrawThread;

public class Main {
    public static final Map map = new Map(10, 40);
    public static final Logging logging = new Logging(map.getHEIGHT());
    public static void main(String[] args) {
        EdibilityTable.init();
        AnimalGenerator.init();
        PlantSpawner.init();

        Thread thread4 = new DrawThread();

        thread4.start();
    }
}