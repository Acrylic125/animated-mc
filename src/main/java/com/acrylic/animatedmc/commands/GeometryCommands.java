package com.acrylic.animatedmc.commands;

import com.acrylic.animatedmc.geometry.Circle;
import com.acrylic.animatedmc.math.Matrix3;
import com.acrylic.animatedmc.geometry.Spiral;
import me.lucko.helper.Commands;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
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

                    Matrix3 matrix = Matrix3.create().rotateByYawAndPitch(location.getYaw(), location.getPitch());
                    Bukkit.broadcastMessage(matrix.toString());

                    spiral.setTransformationMatrix(matrix);
                    for (int i = 0; i < spiral.getInterpolationPoints() * 3; i++) {
                        Location point = spiral.step(i);
                        player.sendBlockChange(point, (i == 4) ? Material.RED_WOOL.createBlockData() : Material.EMERALD_BLOCK.createBlockData());
                    }
                })
                .register("test-spiral");
    }

}
