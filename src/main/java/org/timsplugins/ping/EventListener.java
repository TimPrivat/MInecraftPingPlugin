package org.timsplugins.ping;

import java.util.Date;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.LightningStrike.Spigot;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PigZapEvent;
import org.bukkit.event.entity.PigZombieAngerEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.world.ChunkEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatColor;

public class EventListener implements Listener {


    public EventListener(JavaPlugin plugins) {

        plugins.getServer().getPluginManager().registerEvents(this, plugins);

    }

    public static int playersInBed = 0;

    //Jesus christ man kann Lambdas nicht mit Annotations verwenden...
    @EventHandler
    private void increaseplayersInBed(PlayerBedEnterEvent e) {
        playersInBed++;

        if (ServerPlugin.getOnlinePlayers().size() <= 2)
            return;

        if (playersInBed > Math.round(ServerPlugin.getOnlinePlayers().size() / 2)) {
            Bukkit.broadcastMessage("Überspringe die Nacht da die Hälfte der Spieler schläft");
            ServerPlugin.getOnlinePlayers().get(1).getWorld().setTime(0);

        } else {

            Bukkit.broadcastMessage("Es müssen noch " + (Math.round(ServerPlugin.getOnlinePlayers().size() / 2) - playersInBed + " Spieler schlafen, um die NAcht zu überspringen"));
        }
    }

    @EventHandler
    private void deceraseplayersInBed(PlayerBedLeaveEvent e) {
        playersInBed--;
    }

}







	
	


		
	
	
	
			 
				
				
				
	
	
		
		
		
	


	
	
	
	
	
		
		
	
	
	



	

