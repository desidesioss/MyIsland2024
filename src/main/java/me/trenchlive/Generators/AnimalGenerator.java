package me.trenchlive.Generators;

import me.trenchlive.AnimalsAndBase.Entity;
import me.trenchlive.AnimalsAndBase.Herbivores.*;
import me.trenchlive.AnimalsAndBase.Predators.*;
import me.trenchlive.Tools.Point2DInt;
import static me.trenchlive.Main.map;
import static me.trenchlive.Tools.Point2DInt.randomPointInRange;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class AnimalGenerator {
    private static final int ANIMALS_QUANTITY = 10;
    private static final Random random = new Random();
    public static void init() {
        Class<Entity>[] animalTypes = new Class[]{Wolf.class, Boa.class, Fox.class, Bear.class, Eagle.class, Horse.class, Deer.class, Rabbit.class, Mouse.class, Goat.class, Sheep.class, Boar.class, Buffalo.class, Duck.class, Caterpillar.class};

        for (int i = 0; i < ANIMALS_QUANTITY; i++) {
            int randomIndex = random.nextInt(animalTypes.length);
            Class<? extends Entity> animalClass = animalTypes[randomIndex];

            try {
                map.addEntities(animalClass.getDeclaredConstructor(Point2DInt.class).newInstance(randomPointInRange(0,0, map.getHEIGHT(), map.getWIDTH())));
            } catch (InstantiationException | IllegalAccessException |
                     NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
