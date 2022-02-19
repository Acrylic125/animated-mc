package com.acrylic.animatedmc.geometry;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class Line implements Geometry {

    private Location origin;
    private double deltaX, deltaY, deltaZ;

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public void setToLocation(Location location, int interpolationPoints) {
        Location difference = location.clone().subtract(origin);
        difference.multiply(1.0 / interpolationPoints);
        this.deltaX = difference.getX();
        this.deltaY = difference.getY();
        this.deltaZ = difference.getZ();
    }

    @Override
    public Location getOrigin() {
        return this.origin;
    }

    @Override
    public Location step(int index) {
        return new Location(origin.getWorld(),
                origin.getX() + (deltaX * index),
                origin.getY() + (deltaY * index),
                origin.getZ() + (deltaZ * index)
        );
    }

    public void setDelta(Vector delta) {
        setDeltaX(delta.getX());
        setDeltaY(delta.getY());
        setDeltaZ(delta.getZ());
    }

    public Vector getDeltaVector() {
        return new Vector(deltaX, deltaY, deltaZ);
    }

    public double getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }

    public double getDeltaZ() {
        return deltaZ;
    }

    public void setDeltaZ(double deltaZ) {
        this.deltaZ = deltaZ;
    }
}
