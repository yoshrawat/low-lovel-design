package com.yogesh.schedulingjob;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class Machine<T> {
    public final AtomicInteger cpu, ram, core;  // available cpu/ram
    public final int cfgCPU, cfgRAM, cfgCore;// default configured CPU/RAM
    private final ExecutorService executor = Executors.newWorkStealingPool();
    private TreeSet<Machine<T>> machinePool;

    public Machine(int cpu, int ram, int core, TreeSet<Machine<T>> machinePool) {
        this.cpu = new AtomicInteger(this.cfgCPU = cpu);
        this.ram = new AtomicInteger(this.cfgRAM = ram);
        this.core = new AtomicInteger(this.cfgCore = core);
        this.machinePool = machinePool;
    }

    public Future<T> submit(final Task<T> task) {
        if (this.cpu.get() < task.cpu || this.ram.get() < task.ram) {
            throw new RuntimeException("Not enough resource");
        }
        this.cpu.set(this.cpu.get() - task.cpu);
        this.ram.set(this.ram.get() - task.ram);
        this.core.decrementAndGet();
        return executor.submit(() -> {
            T res = task.execute();
            this.cpu.set(this.cpu.get() + task.cpu);
            this.ram.set(this.ram.get() + task.ram);
            this.core.getAndIncrement();
            machinePool.remove(this);
            machinePool.add(this);    // reorder
            return res;
        });
    }
}
