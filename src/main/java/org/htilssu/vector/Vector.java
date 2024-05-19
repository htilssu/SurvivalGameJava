package org.htilssu.vector;

public abstract class Vector {
    public float x = 0;
    public float y = 0;

    public abstract void add(Vector vector);

    public abstract void subtract(Vector vector);

    public abstract void multiply(float scalar);

    public abstract void divide(float scalar);

}
