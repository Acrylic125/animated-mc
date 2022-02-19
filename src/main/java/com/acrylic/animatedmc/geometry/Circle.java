package com.acrylic.animatedmc.geometry;

import com.acrylic.animatedmc.math.Matrix3;
import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public class Circle
        implements Geometry, Transformable {

    private int interpolationPoints = 16;
    private float radius, baseRadians;
    private Location origin;
    private Matrix3 matrix;

    public int getInterpolationPoints() {
        return interpolationPoints;
    }

    public void setInterpolationPoints(int interpolationPoints) {
        this.interpolationPoints = interpolationPoints;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getBaseRadians() {
        return baseRadians;
    }

    public void setBaseRadians(float baseRadians) {
        this.baseRadians = baseRadians;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    @Override
    public Location getOrigin() {
        return this.origin;
    }

    private double fromIndexToRadians(int index) {
        return this.baseRadians + (index * 2 * Math.PI / this.interpolationPoints);
    }

    @Override
    public Location step(int index) {
        double rad = fromIndexToRadians(index);
        double cos = Math.cos(rad), sin = Math.sin(rad);
        double dX = radius * cos, dZ = radius * sin;

        final Location location = new Location(origin.getWorld(), dX, 0, dZ);

        if (matrix != null) {
            matrix.transform(location);
        }
        location.add(origin.getX(), origin.getY(), origin.getZ());
        return location;
    }

    @Nullable
    @Override
    public Matrix3 getTransformationMatrix() {
        return matrix;
    }

    @Override
    public void setTransformationMatrix(@Nullable Matrix3 matrix) {
        this.matrix = matrix;
    }
}
