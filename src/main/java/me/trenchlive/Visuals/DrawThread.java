package me.trenchlive.Visuals;


public class DrawThread extends Thread {
    @Override
    public void run() {
        while (true) {
            Draw.scene();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
