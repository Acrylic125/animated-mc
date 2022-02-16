package com.acrylic.animatedmc.math;

import org.bukkit.Location;

public interface Geometry {

    Location getOrigin();

    Location step(int index);

}
