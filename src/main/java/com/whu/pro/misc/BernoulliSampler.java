package com.whu.pro.misc;

import java.util.Random;

public class BernoulliSampler {
    private final double percent;
    private final Random rnd;
    private Double nextRnd = null;

    public BernoulliSampler(double percent) {
        this.percent = percent;
        this.rnd = new Random();
        stage();
    }

    public boolean next() {
        boolean val = check();
        stage();
        return val;
    }

    public boolean check() {
        return nextRnd < percent;
    }

    private void stage() {
        nextRnd = rnd.nextDouble();
    }

}
