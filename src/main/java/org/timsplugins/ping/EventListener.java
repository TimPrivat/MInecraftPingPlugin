package org.timsplugins.ping;

import java.util.*;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;

import org.bukkit.*;
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

public class EventListener implements Listener {


    public EventListener(JavaPlugin plugins) {

        plugins.getServer().getPluginManager().registerEvents(this, plugins);

        //added Begrüßungen
        greetings.add("Ahoihoi");
        greetings.add("Aloha");
        greetings.add("Alles cool im Pool?");
        greetings.add("Alles klar in Kanada?");
        greetings.add("Alles Roger in Kambodscha?");
        greetings.add("Gib Flosse, Genosse");
        greetings.add("Grüetzi");
        greetings.add("Grüßli Müsli");
        greetings.add("Halo i bims");
        greetings.add("Hallihallohallöle");
        greetings.add("Hallöchen Popöchen");
        greetings.add("Hallöchen mit Öchen");
        greetings.add("Hola");
        greetings.add("Howdy");
        greetings.add("Juten Tach");
        greetings.add("Moinjour");
        greetings.add("Palim Palim");
        greetings.add("Servus, Haselnuss");
        greetings.add("Soos was los?");
        greetings.add("Tuten Gag");
        greetings.add("Whazuuuuuuuup?");
        greetings.add("Yo Moinsen");
        greetings.add("*Tips Fedora* M'");


    }

    public static int playersInBed = 0;

    //Jesus christ man kann Lambdas nicht mit Annotations verwenden...
    @EventHandler
    private void increaseplayersInBed(PlayerBedEnterEvent e) {
        playersInBed++;


        if (playersInBed >= Math.round(ServerPlugin.getOnlinePlayers().size() / 2) && ServerPlugin.getOnlinePlayers().get(0).getWorld().getTime()>13000) {
            Bukkit.broadcastMessage("Überspringe die Nacht da die Hälfte der Spieler schläft");
            ServerPlugin.getOnlinePlayers().get(0).getWorld().setTime(0);


        } else if(playersInBed < Math.round(ServerPlugin.getOnlinePlayers().size() / 2)&&ServerPlugin.getOnlinePlayers().get(0).getWorld().getTime()>12542 ) {

            Bukkit.broadcastMessage("Es müssen noch " + (Math.round(ServerPlugin.getOnlinePlayers().size() / 2) - playersInBed + " Spieler schlafen, um die Nacht zu überspringen"));
        }else{
            Player p = e.getPlayer();
            p.sendMessage("Man kann nur"+ ChatColor.LIGHT_PURPLE+ " Nachts "+ ChatColor.WHITE+"schlafen");

        }
        playersInBed=0;
    }

    @EventHandler
    private void deceraseplayersInBed(PlayerBedLeaveEvent e) {
        playersInBed--;
        if(playersInBed < 0)
            playersInBed=0;
    }


    ArrayList<String> greetings = new ArrayList<>();
    @EventHandler
    private void begrüßungOnJoin(PlayerJoinEvent e) {

    Random r = new Random();
    Player p =e.getPlayer();
    String gruß= greetings.get(r.nextInt(greetings.size()));
    Bukkit.broadcastMessage(gruß+" "+org.bukkit.ChatColor.GREEN+p.getName());

    }


}



	
	


		
	
	
	
			 
				
				
				
	
	
		
		
		
	


	
	
	
	
	
		
		
	
	
	



	

