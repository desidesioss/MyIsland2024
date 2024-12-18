package me.trenchlive.LandscapeAndMap;

import me.trenchlive.AnimalsAndBase.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private int HEIGHT;
    private int WIDTH;
    private Cell[][] MAP;
    private volatile List<Entity> entities = new ArrayList<>();

    public Map(int _HEIGHT, int _WIDTH) {
        HEIGHT = _HEIGHT;
        WIDTH = _WIDTH;
        init();
    }

    private void init() {
        MAP = new Cell[HEIGHT][WIDTH];
        MAP = Arrays.stream(MAP)
                .map(row -> new Cell[WIDTH])
                .map(row -> Arrays.stream(row).map(cell -> new Cell()).toArray(Cell[]::new))
                .toArray(Cell[][]::new);
    }

    synchronized private void change() {

    }

    synchronized public int getHEIGHT() {
        return HEIGHT;
    }

    synchronized private void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
        init();
    }

    synchronized public int getWIDTH() {
        return WIDTH;
    }

    synchronized private void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
        init();
    }

    synchronized public Cell[][] getMAP() {
        return MAP;
    }

    synchronized public List<Entity> getEntities() {
        return entities;
    }

    synchronized public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    synchronized public void addEntities(Entity... entities) {
        this.entities.addAll(Arrays.stream(entities).toList());
    }

    synchronized public void removeEntities(Entity... entities) {
        this.entities.removeAll(Arrays.stream(entities).toList());
    }
}