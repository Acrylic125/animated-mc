package com.acrylic.animatedmc;

import com.acrylic.animatedmc.commands.GeometryCommands;
import me.lucko.helper.plugin.ExtendedJavaPlugin;

public final class AnimatedMc extends ExtendedJavaPlugin {

    @Override
    public void enable() {
       new GeometryCommands(this).registerAll();
    }

}
