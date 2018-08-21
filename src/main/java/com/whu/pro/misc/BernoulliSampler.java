package com.whu.pro.misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import com.whu.pro.controller.PointsController;

public class BernoulliSampler {
    private BufferedWriter writer;
    private final double percent;
    private final Random rnd;
    private Double nextRnd = null;

    public BernoulliSampler(double percent) {
        this.percent = percent;
        this.rnd = new Random();
        try {
            if (PointsController.DBG_INFO)
                this.writer = new BufferedWriter(new FileWriter("D:\\bernoulli.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        if (writer != null) {
            try {
                if (PointsController.DBG_INFO)
                    writer.write(nextRnd + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        try {
            if (PointsController.DBG_INFO)
                this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
