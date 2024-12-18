package me.trenchlive.Logging;

import me.trenchlive.Tools.LimitedQueue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logging {
    private LimitedQueue<String> logs;
    private static int capacity;

    public Logging(int _capacity) {
        capacity = _capacity;
        logs = new LimitedQueue<>(capacity);
    }

    public void logAdd(String log) {
        logs.add(log);
    }

    public LimitedQueue<String> getLogs() {
        return logs;
    }

    public static String log(Object _who, String _action) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime + "\t|\t" + _who.getClass().getSimpleName() + " " + _action;
    }
}
