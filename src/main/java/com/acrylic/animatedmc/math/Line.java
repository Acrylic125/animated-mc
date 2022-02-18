package com.acrylic.animatedmc.math;

import org.bukkit.Location;

public class Line implements Geometry {

    private Location origin;
    private int interpolationPoints = 10;
    private double deltaX;
    private double deltaY;
    private double deltaZ;

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public void setToLocation(Location location) {
        Location difference = location.clone().subtract(origin);
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
        double percent = index / (double) interpolationPoints;
        return new Location(origin.getWorld(),
                origin.getX() + (deltaX * percent),
                origin.getY() + (deltaY * percent),
                origin.getZ() + (deltaZ * percent)
        );
    }

    public int getInterpolationPoints() {
        return interpolationPoints;
    }

    public void setInterpolationPoints(int interpolationPoints) {
        this.interpolationPoints = interpolationPoints;
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
