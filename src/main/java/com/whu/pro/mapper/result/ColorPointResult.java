package com.whu.pro.mapper.result;

public class ColorPointResult {
    private float x;
    private float y;
    private float z;
    private int r;
    private int g;
    private int b;

    public ColorPointResult(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public ColorPointResult(float x, float y, float z, int r, int g, int b) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}
