package org.htilssu.utils;

public final class MatrixUtil {
    float[][] multiply(float[][] a, float[][] b) {

        if (a[1].length != b.length) {
            return null;
        }

        float[][] result = new float[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }
}
