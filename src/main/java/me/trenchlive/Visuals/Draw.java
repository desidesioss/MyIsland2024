package me.trenchlive.Visuals;

import me.trenchlive.AnimalsAndBase.Entity;
import me.trenchlive.LandscapeAndMap.Cell;
import me.trenchlive.Tools.Point2DInt;

import java.util.List;

import static me.trenchlive.AnimalsAndBase.Animal.getAnimalsOnCoordinates;
import static me.trenchlive.Main.logging;
import static me.trenchlive.Main.map;

public class Draw {

    public static void scene() {
        clear();
        topBorder();
        mapWithLogs();
        bottomBorder();
    }

    private static void topBorder() {
        StringBuilder border = new StringBuilder();
        border.append("┌");
        for (int i = 0; i < map.getWIDTH(); i++) {
            border.append("─");
        }
        border.append("┐");
        System.out.println(border);
    }

    private static void bottomBorder() {
        StringBuilder border = new StringBuilder();
        border.append("└");
        for (int i = 0; i < map.getWIDTH(); i++) {
            border.append("─");
        }
        border.append("┘");
        System.out.println(border);
    }

    private static void mapWithLogs() {
        for (int i = 0; i < map.getHEIGHT(); i++) {
            System.out.print("│");
            Row(i);
            String log = logging.getLogs().get(i);
            if(log == null)
                log = "";
            System.out.println("│\t" + log);
        }
    }

    private static void Row(int rowIndex) {
        for (int j = 0; j < map.getWIDTH(); j++) {
            cell(map.getMAP()[rowIndex][j], new Point2DInt(rowIndex, j));
        }
    }

    private static void cell(Cell cell, Point2DInt pos) {
        if(cell.isGround()) {
            List<Entity> temp = getAnimalsOnCoordinates(pos);
            if (temp.isEmpty()) {
                System.out.print("░");
            }
            else {
                System.out.print(temp.get(0).toString());
            }
        }
        else {
            System.out.print("█");
        }
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
