package org.htilssu.vector;

public class Vector2D extends Vector {

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setVector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void add(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
    }


    @Override
    public void subtract(Vector vector) {
        this.x -= vector.x;
        this.y -= vector.y;
    }

    @Override
    public void multiply(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }

    @Override
    public void divide(float scalar) {
        this.x /= scalar;
        this.y /= scalar;
    }


}
