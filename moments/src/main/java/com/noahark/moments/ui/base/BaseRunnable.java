package com.noahark.moments.ui.base;

public class BaseRunnable implements Runnable {
    private Object object;

    protected BaseRunnable(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        run(object);
    }

    public void run(Object object) {

    }
}
