package me.trenchlive.Tools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LimitedQueue<T> {
    private final int limit;
    private final LinkedList<T> queue;

    public LimitedQueue(int limit) {
        this.limit = limit;
        this.queue = new LinkedList<>();
    }

    synchronized public void add(T value) {
        if (queue.size() >= limit) {
            queue.poll();
        }
        queue.add(value);
    }

    synchronized public T poll() {
        return queue.poll();
    }

    synchronized public T peek() {
        return queue.peek();
    }

    synchronized public int size() {
        return queue.size();
    }

    synchronized public T get(int index) {
        if (index < 0 || index >= queue.size()) {
            return null;
        }
        return queue.get(index);
    }

    @Override
    synchronized public String toString() {
        return queue.toString();
    }
}
