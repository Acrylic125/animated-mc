package com.acrylic.animatedmc.geometry;

import com.acrylic.animatedmc.math.Matrix3;
import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public class Spiral
    implements Geometry, Transformable {

    private int interpolationPoints = 16, arms = 1;
    private float baseRadius, baseRadians, deltaRadius = 1f, deltaRadians = 0.1f;
    private Location origin;
    private Matrix3 matrix;

    public int getInterpolationPoints() {
        return interpolationPoints;
    }

    public void setInterpolationPoints(int interpolationPoints) {
        this.interpolationPoints = interpolationPoints;
    }

    public int getArms() {
        return arms;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    public float getBaseRadius() {
        return baseRadius;
    }

    public void setBaseRadius(float baseRadius) {
        this.baseRadius = baseRadius;
    }

    public float getBaseRadians() {
        return baseRadians;
    }

    public void setBaseRadians(float baseRadians) {
        this.baseRadians = baseRadians;
    }

    public float getDeltaRadius() {
        return deltaRadius;
    }

    public void setDeltaRadius(float deltaRadius) {
        this.deltaRadius = deltaRadius;
    }

    public float getDeltaRadians() {
        return deltaRadians;
    }

    public void setDeltaRadians(float deltaRadians) {
        this.deltaRadians = deltaRadians;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    @Override
    public Location getOrigin() {
        return origin;
    }

    private double fromIndexToRadians(int index) {
        int armIndex = fromIndexToArmIndex(index);
        return this.baseRadians +
                (armIndex * calculateRadiansApartFromArms()) +
                (((float) index / arms) * deltaRadians);
    }

    private double fromIndexToRadius(int index) {
        return this.baseRadius +
                (((float) index / arms) * deltaRadius);
    }

    private int fromIndexToArmIndex(int index) {
        return (index - 1) % arms;
    }

    private double calculateRadiansApartFromArms() {
        return 2 * Math.PI / arms;
    }

    @Override
    public Location step(int index) {
        double rad = fromIndexToRadians(index), radius = fromIndexToRadius(index);
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
        return this.matrix;
    }

    @Override
    public void setTransformationMatrix(@Nullable Matrix3 matrix) {
        this.matrix = matrix;
    }
}
