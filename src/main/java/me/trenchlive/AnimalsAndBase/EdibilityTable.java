package me.trenchlive.AnimalsAndBase;


import me.trenchlive.AnimalsAndBase.Herbivores.*;
import me.trenchlive.AnimalsAndBase.Predators.*;
import me.trenchlive.Tools.Tools;

public class EdibilityTable {
    public static void init() {
        Tools.mapPutAll(Wolf.IEat,          Horse.class,        10, Deer.class,         15, Rabbit.class,   60, Mouse.class,        80, Goat.class,     60, Sheep.class,    70, Boar.class,     15, Buffalo.class,  10, Duck.class,     40);
        Tools.mapPutAll(Boa.IEat,           Fox.class,          15, Rabbit.class,       20, Mouse.class,    40, Duck.class,         10);
        Tools.mapPutAll(Fox.IEat,           Rabbit.class,       70, Mouse.class,        90, Duck.class,     60, Caterpillar.class,  40);
        Tools.mapPutAll(Bear.IEat,          Boa.class,          80, Horse.class,        40, Deer.class,     80, Rabbit.class,       80, Mouse.class,    90, Goat.class,     70, Sheep.class,    70, Boar.class,     50, Buffalo.class,  20, Duck.class, 10);
        Tools.mapPutAll(Eagle.IEat,         Fox.class,          10, Rabbit.class,       90, Mouse.class,    90, Duck.class,         80);
        Tools.mapPutAll(Horse.IEat,         Plant.class,        100);
        Tools.mapPutAll(Deer.IEat,          Plant.class,        100);
        Tools.mapPutAll(Rabbit.IEat,        Plant.class,        100);
        Tools.mapPutAll(Mouse.IEat,         Caterpillar.class,  90, Plant.class,        100);
        Tools.mapPutAll(Goat.IEat,          Plant.class,        100);
        Tools.mapPutAll(Sheep.IEat,         Plant.class,        100);
        Tools.mapPutAll(Boar.IEat,          Mouse.class,        50, Caterpillar.class,  90, Plant.class,    100);
        Tools.mapPutAll(Buffalo.IEat,       Plant.class,        100);
        Tools.mapPutAll(Duck.IEat,          Caterpillar.class,  90, Plant.class,        100);
        Tools.mapPutAll(Caterpillar.IEat,   Plant.class,        100);
    }
}
