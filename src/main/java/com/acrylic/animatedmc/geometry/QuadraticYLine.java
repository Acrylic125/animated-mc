package com.acrylic.animatedmc.geometry;

import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;


public class QuadraticYLine extends Line {

    private float yOffset= 0, yMultiplier = 1;
    private int estimatedDistance;

    public float getYOffset() {
        return yOffset;
    }

    public void setYOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public float getYMultiplier() {
        return yMultiplier;
    }

    public void setYMultiplier(float yMultiplier) {
        this.yMultiplier = yMultiplier;
    }

    @Override
    public void setToLocation(Location location, int interpolationPoints) {
        @Nullable Location origin = getOrigin();

        assert origin != null;

        this.estimatedDistance = (int) origin.distance(location);

        Vector deltaVector = (location.toVector().add(origin.toVector().multiply(-1))).multiply(1.0 / interpolationPoints);
        setDelta(deltaVector);

    }

    @Override
    public Location step(int index) {
        Vector deltaVector = getDeltaVector().clone().setY(calculateY(index));
        @Nullable Location origin = getOrigin();

        assert origin != null;
        return origin.clone().add(deltaVector);
    }

    private double calculateY(int index) {
        return (yMultiplier * index * (index - estimatedDistance)) + yOffset;
    }
}
