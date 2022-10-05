package com.yogesh.schedulingjob;

public abstract class Task<T> {
    public int cpu, ram; // required CPU, RAM for this task

    abstract T execute();    // execute the task and return the computed result of type T
}
