package com.acrylic.animatedmc.geometry;

import org.bukkit.Location;

public interface Geometry {

    Location getOrigin();

    Location step(int index);

}
