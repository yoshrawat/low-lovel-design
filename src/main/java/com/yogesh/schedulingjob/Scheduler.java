package com.yogesh.schedulingjob;

import java.util.*;
import java.util.concurrent.*;

public class Scheduler<T> {
    final TreeSet<Machine<T>> machinePool = new TreeSet<>((a, b) -> a.cpu != b.cpu ? a.cpu.get() -
            b.cpu.get() : (a.ram != b.ram ? a.ram.get() - b.ram.get() : a.core.get() - b.core.get()));

    public Future<T> submit(Task<T> task) {
        Machine<T> required = new Machine(task.cpu, task.ram, 1, machinePool);
        Machine<T> found = machinePool.ceiling(required);
        if (null == found) throw new RuntimeException("All machine busy");
        Future<T> future = found.submit(task);
        machinePool.remove(found);
        machinePool.add(found);    // reorder
        return future;
    }
}
