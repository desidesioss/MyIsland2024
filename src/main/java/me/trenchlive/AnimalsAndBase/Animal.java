package me.trenchlive.AnimalsAndBase;

import me.trenchlive.Tools.Tools;
import me.trenchlive.Tools.Point2DInt;

import static me.trenchlive.Logging.Logging.log;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

import static me.trenchlive.Main.logging;
import static me.trenchlive.Main.map;


public abstract class Animal extends Entity {
    private static int instanceCount = 0;
    private static final Object lock = new Object();
    private static CyclicBarrier barrier;

    protected volatile int MAX_STEP;
    protected volatile double SATURATION_CAPACITY;
    protected volatile double current_saturation;

    public Animal(Point2DInt _xy) {
        super(_xy);
        synchronized (lock) {
            instanceCount++;
            if (barrier == null) {
                barrier = new CyclicBarrier(instanceCount);
            } else {
                barrier.reset();
            }
        }

        new Thread(this::run).start();
    }

    private void run() {
        current_saturation = SATURATION_CAPACITY * 0.75;
        while (!isDead() && current_saturation > 0) {
            step();
        }
    }

    protected boolean isDead() {
        return DEAD;
    }

    protected void waitForOthers() {
        try {
            //logging.logAdd(log(this, "IS WAITING FOR OTHERS"));
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    protected void step() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        if (current_saturation < SATURATION_CAPACITY) {
            Point2DInt found_food = searchForFood();
            if (found_food == null) {
                moveInRandomDirection();
                return;
            }
            if (Tools.calculateDistance(this.XY, found_food) < 2) {
                attemptToEat(found_food);
            }
            moveInDirectionTo(found_food);
            waitForOthers();
            return;
        }
        attemptToReproduce();//
        saturationReduce();
        waitForOthers();
    }

    protected void saturationReduce() {
        current_saturation = SATURATION_CAPACITY / 2;
        logging.logAdd(log(this, "became hungry, current saturation: " + current_saturation));
    }

    synchronized protected void attemptToEat(Point2DInt _target) {
        List<Entity> entitiesAtTarget = getAnimalsOnCoordinates(_target);
        for (Entity entity : entitiesAtTarget) {
            if (entity != null) {
                if (canEat(entity)) {
                    tryToEat(entity);
                }
            }
        }
    }

    synchronized private boolean canEat(Entity _entity) {
        return getIEat().containsKey(_entity.getClass());
    }

    private void tryToEat(Entity _entity) {
        int possibility = getIEat().get(_entity.getClass());
        int rnd = ThreadLocalRandom.current().nextInt(possibility);

        logging.logAdd(log(this, "attempt to eat " + _entity.getClass().getSimpleName() +
                " possibility " + possibility + "%"));

        if (rnd < possibility) {
            eat(_entity);
        } else {
            logging.logAdd(log(this, "did not eat " + _entity.getClass().getSimpleName()));
        }
    }

    protected void eat(Entity _entity) {
        _entity.DEAD = true;
        current_saturation += _entity.WEIGHT;
        map.removeEntities(_entity);
        logging.logAdd(log(this, "ate " + _entity.getClass().getSimpleName()));
    }

    synchronized public static List<Entity> getAnimalsOnCoordinates(Point2DInt _target) {
        List<Entity> res = new ArrayList<>();
        ArrayList<Entity> entitiesCopy = new ArrayList<>(map.getEntities());
        for (Entity entity : entitiesCopy) {
            if (entity != null) {
                if (entity.XY.equals(_target)) {
                    res.add(entity);
                }
            }
        }

        return res;
    }

    synchronized protected void attemptToReproduce() {
        List<Entity> entitiesAtTarget = getAnimalsOnCoordinates(this.XY);
        for (Entity entity : entitiesAtTarget) {
            if (entity != null) {
                if (canReproduce(entity)) {
                    tryToReproduce(entity);
                }
            }
        }
    }

    private boolean canReproduce(Entity _entity) {
        if (this != _entity)
            return this.getClass() == _entity.getClass();
        return false;
    }

    private void tryToReproduce(Entity _entity) {
        int possibility = 50;
        int rnd = ThreadLocalRandom.current().nextInt(100);

        logging.logAdd(log(this, "attempt to reproduce " + _entity.getClass().getSimpleName() +
                " possibility " + possibility + "%"));

        if (rnd < possibility) {
            reproduce();
        } else {
            logging.logAdd(log(this, "did not reproduce " + _entity.getClass().getSimpleName()));
        }
    }

    protected abstract void reproduce();

    /**
     * Ищет ближайшую добычу
     */
    synchronized protected Point2DInt searchForFood() {
        logging.logAdd(log(this, "hungry, saturation: " + current_saturation));

        Point2DInt closest_animal = null;
        double closest_distance = Double.MAX_VALUE;

        ArrayList<Entity> entitiesCopy = new ArrayList<>(map.getEntities());
        for (Entity entity : entitiesCopy) {
            if (entity != null) {
                if(getIEat().containsKey(entity.getClass())) {
                    double distance = Tools.calculateDistance(this.XY, entity.XY);
                    if(distance < closest_distance) {
                        closest_animal = entity.XY;
                    }
                }
            }
        }
        return closest_animal;
    }

    protected void moveInRandomDirection() {
        logging.logAdd(log(this, "goes in random direction"));
        int x = ThreadLocalRandom.current().nextInt(-MAX_STEP, MAX_STEP + 1);
        int y = ThreadLocalRandom.current().nextInt(-MAX_STEP, MAX_STEP + 1);
        move(new Point2DInt(this.XY.getX() + x, this.XY.getY() + y));
    }

    protected void moveInDirectionTo(Point2DInt _target) {
        logging.logAdd(log(this, "goes in direction to " + _target));

        if (Math.floor(Tools.calculateDistance(this.XY, _target)) < MAX_STEP){
            move(_target);
            return;
        }

        if (this.XY.equals(_target)) {
            return;
        }

        int deltaX = _target.getX() - this.XY.getX();
        int deltaY = _target.getY() - this.XY.getY();

        if (Math.abs(deltaX) > MAX_STEP) {
            deltaX = (deltaX < 0) ? -MAX_STEP : MAX_STEP;
        }

        if (Math.abs(deltaY) > MAX_STEP) {
            deltaY = (deltaY < 0) ? -MAX_STEP : MAX_STEP;
        }

        move(new Point2DInt(this.XY.getX() + deltaX, this.XY.getY() + deltaY));
    }

    protected void move(Point2DInt _xy) {
        if (_xy.getY() < 0 || _xy.getY() >= map.getWIDTH() ||
                _xy.getX() < 0 || _xy.getX() >= map.getHEIGHT()) {
            return;
        }
        this.XY = _xy;
        logging.logAdd(log(this, "current position: " + this.XY));
    }

    public abstract String toString();

    public abstract HashMap<Class<?>, Integer> getIEat();

}
