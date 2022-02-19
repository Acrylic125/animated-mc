package com.acrylic.animatedmc.animationentity;

import org.bukkit.Location;

/**
 * Entity Animations uses AnimationEntity to control how the entity
 * will look like. This hides all other logic other than the
 */
public interface AnimationEntity {

    void teleport(Location location);

}
