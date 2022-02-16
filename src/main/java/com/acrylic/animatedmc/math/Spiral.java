package com.acrylic.animatedmc.math;

import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public class Spiral
    implements Geometry, Transformable {

    private int interpolationPoints = 16;
    private float baseRadius, baseRadians, deltaRadius, deltaRadians;
    private Location origin;
    private Matrix3 matrix;

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    @Override
    public Location getOrigin() {
        return origin;
    }

    @Override
    public Location step(int index) {
        return null;
    }

    @Nullable
    @Override
    public Matrix3 getTransformationMatrix() {
        return null;
    }

    @Override
    public void setTransformationMatrix(Matrix3 matrix) {

    }
}
