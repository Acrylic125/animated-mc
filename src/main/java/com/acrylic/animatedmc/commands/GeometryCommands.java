package com.acrylic.animatedmc.commands;

import com.acrylic.animatedmc.math.Circle;
import com.acrylic.animatedmc.math.Spiral;
import me.lucko.helper.Commands;
import me.lucko.helper.command.functional.FunctionalCommandBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GeometryCommands {

    private final JavaPlugin plugin;

    public GeometryCommands(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerAll() {
        this.registerCircleCommand();
        this.registerSpiralCommand();
    }

    private void registerCircleCommand() {
        Commands.create()
                .assertPlayer()
                .handler((command) -> {
                    Player player = command.sender();
                    Location location = player.getLocation();
                    Circle circle = new Circle();
                    circle.setRadius(8);
                    circle.setOrigin(location);
                    for (int i = 0; i < circle.getInterpolationPoints(); i++) {
                        Location point = circle.step(i);
                        player.sendBlockChange(point, Material.EMERALD_BLOCK.createBlockData());
                    }
                })
                .register("test-circle");
    }

    private void registerSpiralCommand() {
        Commands.create()
                .assertPlayer()
                .handler((command) -> {
                    Player player = command.sender();
                    Location location = player.getLocation();
                    Spiral spiral = new Spiral();
                    spiral.setBaseRadius(1);
                    spiral.setOrigin(location);
                    spiral.setArms(3);
                    for (int i = 0; i < spiral.getInterpolationPoints() * 3; i++) {
                        Location point = spiral.step(i);
                        player.sendBlockChange(point, Material.EMERALD_BLOCK.createBlockData());
                    }
                })
                .register("test-spiral");
    }

}
