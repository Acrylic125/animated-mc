package com.acrylic.animatedmc.math;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public final class Matrix3 {

    public static Matrix3 create() {
        return new Matrix3();
    }

    public static Matrix3 from(float[][] matrix) {
        return new Matrix3()
                .set(matrix[0][0], matrix[0][1], matrix[0][2],
                     matrix[1][0], matrix[1][1], matrix[1][2],
                     matrix[2][0], matrix[2][1], matrix[2][2]);
    }

    /**
     * Xx Yx Zx
     * Xy Yy Zy
     * Xz Yz Zz
     *
     * By default, the matrix is an identity matrix.
     */
    float r1c1 = 1, r1c2 = 0, r1c3 = 0,
            r2c1 = 0, r2c2 = 1, r2c3 = 0,
            r3c1 = 0, r3c2 = 0, r3c3 = 1;

    Matrix3() {}

    public Matrix3 set(
            float r1c1, float r1c2, float r1c3,
            float r2c1, float r2c2, float r2c3,
            float r3c1, float r3c2, float r3c3
    ) {
        this.r1c1 = r1c1;
        this.r1c2 = r1c2;
        this.r1c3 = r1c3;
        this.r2c1 = r2c1;
        this.r2c2 = r2c2;
        this.r2c3 = r2c3;
        this.r3c1 = r3c1;
        this.r3c2 = r3c2;
        this.r3c3 = r3c3;
        return this;
    }

    public Matrix3 multiplyWithLeft(
            float r1c1, float r1c2, float r1c3,
            float r2c1, float r2c2, float r2c3,
            float r3c1, float r3c2, float r3c3
    ) {
        return set((r1c1 * this.r1c1) + (r1c2 * this.r2c1) + (r1c3 * this.r3c1), (r1c1 * this.r1c2) + (r1c2 * this.r2c2) + (r1c3 * this.r3c2), (r1c1 * this.r1c3) + (r1c2 * this.r2c3) + (r1c3 * this.r3c3),
                (r2c1 * this.r1c1) + (r2c2 * this.r2c1) + (r2c3 * this.r3c1), (r2c1 * this.r1c2) + (r2c2 * this.r2c2) + (r2c3 * this.r3c2), (r2c1 * this.r1c3) + (r2c2 * this.r2c3) + (r2c3 * this.r3c3),
                (r3c1 * this.r1c1) + (r3c2 * this.r2c1) + (r3c3 * this.r3c1), (r3c1 * this.r1c2) + (r3c2 * this.r2c2) + (r3c3 * this.r3c2), (r3c1 * this.r1c3) + (r3c2 * this.r2c3) + (r3c3 * this.r3c3));
    }

    public Matrix3 multiplyWithRight(
            float r1c1, float r1c2, float r1c3,
            float r2c1, float r2c2, float r2c3,
            float r3c1, float r3c2, float r3c3
    ) {
        return set((this.r1c1 * r1c1) + (this.r1c2 * r2c1) + (this.r1c3 * r3c1), (this.r1c1 * r1c2) + (this.r1c2 * r2c2) + (this.r1c3 * r3c2), (this.r1c1 * r1c3) + (this.r1c2 * r2c3) + (this.r1c3 * r3c3),
                (this.r2c1 * r1c1) + (this.r2c2 * r2c1) + (this.r2c3 * r3c1), (this.r2c1 * r1c2) + (this.r2c2 * r2c2) + (this.r2c3 * r3c2), (this.r2c1 * r1c3) + (this.r2c2 * r2c3) + (this.r2c3 * r3c3),
                (this.r3c1 * r1c1) + (this.r3c2 * r2c1) + (this.r3c3 * r3c1), (this.r3c1 * r1c2) + (this.r3c2 * r2c2) + (this.r3c3 * r3c2), (this.r3c1 * r1c3) + (this.r3c2 * r2c3) + (this.r3c3 * r3c3));
    }

    public float get(int row, int column) {
        switch (row) {
            case 0:
                switch (column) {
                    case 0: return r1c1;
                    case 1: return r1c2;
                    case 2: return r1c3;
                }
                break;
            case 1:
                switch (column) {
                    case 0: return r2c1;
                    case 1: return r2c2;
                    case 2: return r2c3;
                }
                break;
            case 2:
                switch (column) {
                    case 0: return r3c1;
                    case 1: return r3c2;
                    case 2: return r3c3;
                }
                break;
        }
        throw new IllegalArgumentException("Row and column can only be a number between 0 and 2");
    }

    public Matrix3 row(int row, float v1, float v2, float v3) {
        switch (row) {
            case 0:
                r1c1 = v1;
                r1c2 = v2;
                r1c3 = v3;
                break;
            case 1:
                r2c1 = v1;
                r2c2 = v2;
                r2c3 = v3;
                break;
            case 2:
                r3c1 = v1;
                r3c2 = v2;
                r3c3 = v3;
                break;
        }
        return this;
    }

    public Matrix3 column(int column, float v1, float v2, float v3) {
        switch (column) {
            case 0:
                r1c1 = v1;
                r2c1 = v2;
                r3c1 = v3;
                break;
            case 1:
                r1c2 = v1;
                r2c2 = v2;
                r3c2 = v3;
                break;
            case 2:
                r1c3 = v1;
                r2c3 = v2;
                r3c3 = v3;
                break;
        }
        return this;
    }

    public Matrix3 fill(float value) {
        return set(value, value, value, value, value, value, value, value, value);
    }

    public Matrix3 toZero() {
        return fill(0);
    }

    public Matrix3 diagonal(float r1c1, float r2c2, float r3c3) {
        this.r1c1 = r1c1;
        this.r2c2 = r2c2;
        this.r3c3 = r3c3;
        return this;
    }

    public Matrix3 diagonal(float value) {
        return diagonal(value, value, value);
    }

    public Matrix3 toDiagonal(float r1c1, float r2c2, float r3c3) {
        return set(
                r1c1, 0, 0,
                0, r2c2, 0,
                0, 0, r3c3);
    }

    public Matrix3 toDiagonal(float value) {
        return toDiagonal(value, value, value);
    }

    public Matrix3 toIdentity() {
        return this.toDiagonal(1);
    }

    public Matrix3 toTranspose() {
        return this.set(
            this.r1c1, this.r2c1, this.r3c1,
            this.r1c2, this.r2c2, this.r3c2,
            this.r1c3, this.r2c3, this.r3c3
        );
    }

    public Matrix3 rotateXAxis(float sin, float cos) {
        return this.multiplyWithLeft(
                1, 0, 0,
                0, cos, sin,
                0, sin, cos
        );
    }

    public Matrix3 rotateXAxis(double rad) {
        return this.rotateXAxis((float) Math.sin(rad), (float) Math.cos((rad)));
    }

    public Matrix3 rotateYAxis(float sin, float cos) {
        return this.multiplyWithLeft(
                cos, 0, sin,
                0, 1, 0,
                -sin, 0, cos
        );
    }

    public Matrix3 rotateYAxis(double rad) {
        return this.rotateYAxis((float) Math.sin(rad), (float) Math.cos((rad)));
    }

    public Matrix3 rotateZAxis(float sin, float cos) {
        return this.multiplyWithLeft(
                cos, -sin, 0,
                sin, cos, 0,
                0, 0, 1
        );
    }

    public Matrix3 rotateZAxis(double rad) {
        return this.rotateZAxis((float) Math.sin(rad), (float) Math.cos((rad)));
    }

    public Matrix3 rotateByYawAndPitch(float yaw, float pitch) {
        return this.rotateXAxis(Math.toRadians((pitch * -1) - 90))
                   .rotateYAxis(Math.toRadians(yaw * -1));
    }

    public void transform(Vector vector) {
        double x = vector.getX(), y = vector.getY(), z = vector.getZ();
        vector.setX((x * r1c1) + (y * r1c2) + (z * r1c3))
                .setY((x * r2c1) + (y * r2c1) + (z * r2c3))
                .setZ((x * r3c1) + (y * r3c2) + (z * r3c3));
    }

    public void transform(Location location) {
        double x = location.getX(), y = location.getY(), z = location.getZ();
        location.setX((x * r1c1) + (y * r1c2) + (z * r1c3));
        location.setY((x * r2c1) + (y * r2c1) + (z * r2c3));
        location.setZ((x * r3c1) + (y * r3c2) + (z * r3c3));
    }

    @Override
    public String toString() {
        return "Matrix3{\n" +
                r1c1 + ", " + r1c2 + ","  + r1c3 + "\n" +
                r2c1 + ", " + r2c2 + ","  + r2c3 + "\n" +
                r3c1 + ", " + r3c2 + ","  + r3c3 + "\n" +
                '}';
    }
}
