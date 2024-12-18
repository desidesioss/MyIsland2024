package me.trenchlive.Tools;

import java.util.Map;

public class Tools {
    public static double calculateDistance(Point2DInt from, Point2DInt to) {
        return Math.sqrt(Math.pow(from.getX() - to.getX(), 2) + Math.pow(from.getY() - to.getY(), 2));
    }

    public static <K, V> void mapPutAll(Map<K, V> map, Object... keyValues) {
        if (keyValues.length % 2 != 0) {
            throw new IllegalArgumentException("Нечетное количество аргументов: пары ключ-значение должны быть указаны четным числом.");
        }

        for (int i = 0; i < keyValues.length; i += 2) {
            K key = (K) keyValues[i];
            V value = (V) keyValues[i + 1];
            map.put(key, value);
        }
    }
}
