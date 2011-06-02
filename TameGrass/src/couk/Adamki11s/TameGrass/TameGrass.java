package couk.Adamki11s.TameGrass;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class TameGrass extends JavaPlugin {

	public static Logger log = Logger.getLogger("Minecraft");
	public static Server server;
	String logPrefix = "[TameGrass] ";
	String version;
	public static PermissionHandler permissionHandler;
	public static boolean hasPermissions = false;
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		log.info(logPrefix + " TameGrass v" + version + " disabled!");
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		server = getServer();
		PluginManager pm = server.getPluginManager();
		PluginDescriptionFile pdf = this.getDescription();
		version = pdf.getVersion();

		log.info(logPrefix + " TameGrass v" + version + " enabled!");
	}
	
	int notifcount = 0;
	
	int tenthmark;
	
	private void tamegrass(Player player, int radius, World world, Location loc){
		
		
		String eta = "0";
		
		if(radius >= 100){
			if(radius >= 100 && radius <= 150){ eta = "3"; }
			if(radius >= 150 && radius <= 200){ eta = "7"; }
			if(radius >= 200 && radius <= 250){ eta = "12"; }
			if(radius >= 250 && radius <= 300){ eta = "16"; }
			if(radius > 300){ eta = "20+"; }
			player.sendMessage(ChatColor.DARK_GREEN + "[TameGrass] " + ChatColor.GREEN + "Removing grass. Estimated time < " + ChatColor.AQUA + eta + ChatColor.GREEN + " seconds.");
		}
		
		
		double x1 = Math.round(loc.getX() - radius),
		   y1 = Math.round(loc.getY() - radius),
		   z1 = Math.round(loc.getZ() - radius),
		   x2 = Math.round(loc.getX() + radius),
		   y2 = Math.round(loc.getY() + radius),
		   z2 = Math.round(loc.getZ() + radius);
		
		double quartermark = x1 + ((x2 - x1) / 4), halfmark = x1 + ((x2 - x1) / 2), threequartermark = quartermark * 3;
		boolean quarternotif = false, halfnotif = false, thirdnotif = false;
		
		tenthmark = radius / 10;
		
		int blocks = 0;
		
		for(int x = 0; (x1 + x) <= x2; x++){
			for(int y = 0; (y1 + y) <= y2; y++){
				for(int z = 0; (z1 + z) <= z2; z++){
					
					//if(radius > 250){ 
						//notifications(player, (int) (x + x1), tenthmark, (int) x1);
					//}
					
					//if(world.getBlockTypeIdAt(new Location(world, x1 + x, y1 + y, z1 + z)) == 2 && world.getBlockTypeIdAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)) != 78 &&
						//	(world.getBlockTypeIdAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)) == 0) && world.getBlockTypeIdAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)) != 27 ||
							//world.getBlockTypeIdAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)) == 28 || ){
					if(world.getBlockTypeIdAt(new Location(world, x1 + x, y1 + y, z1 + z)) == 31){
						world.getBlockAt(new Location(world, x1 + x, y1 + y, z1 + z)).setTypeId(0);
						blocks++;
					}
				}
			}
		}
		
		
		
		player.sendMessage(ChatColor.DARK_GREEN + "[TameGrass] " + ChatColor.GREEN + "Long grass removed from " + ChatColor.AQUA + blocks + ChatColor.GREEN + " blocks.");
		
		if(radius > 200){
			server.dispatchCommand((CommandSender) player, "save-all");
			}
		
	}

	private void spawngrass(Player player, int radius, World world, Location loc){
		
		String eta = "0";
		
		if(radius >= 100){
			if(radius >= 100 && radius <= 150){ eta = "3"; }
			if(radius >= 150 && radius <= 200){ eta = "7"; }
			if(radius >= 200 && radius <= 250){ eta = "12"; }
			if(radius >= 250 && radius <= 300){ eta = "16"; }
			if(radius > 300){ eta = "20+"; }
			player.sendMessage(ChatColor.DARK_GREEN + "[TameGrass] " + ChatColor.GREEN + "Spawning grass. Estimated time < " + ChatColor.AQUA + eta + ChatColor.GREEN + " seconds.");
		}
		
		double x1 = Math.round(loc.getX() - radius),
			   y1 = Math.round(loc.getY() - radius),
			   z1 = Math.round(loc.getZ() - radius),
			   x2 = Math.round(loc.getX() + radius),
			   y2 = Math.round(loc.getY() + radius),
			   z2 = Math.round(loc.getZ() + radius);
		
		double quartermark = x1 + ((x2 - x1) / 4), halfmark = x1 + ((x2 - x1) / 2), threequartermark = quartermark * 3;
		boolean quarternotif = false, halfnotif = false, thirdnotif = false;
		
		tenthmark = radius / 10;
		
		int blocks = 0;
		
		for(int x = 0; (x1 + x) <= x2; x++){
			for(int y = 0; (y1 + y) <= y2; y++){
				for(int z = 0; (z1 + z) <= z2; z++){
					
					//if(radius > 250){ 
						//notifications(player, (int) (x + x1), tenthmark, (int) x1);
					//}
					
					//if(world.getBlockTypeIdAt(new Location(world, x1 + x, y1 + y, z1 + z)) == 2 && world.getBlockTypeIdAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)) != 78 &&
						//	(world.getBlockTypeIdAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)) == 0) && world.getBlockTypeIdAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)) != 27 ||
							//world.getBlockTypeIdAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)) == 28 || ){
					if(world.getBlockTypeIdAt(new Location(world, x1 + x, y1 + y, z1 + z)) == 2 && world.getBlockTypeIdAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)) == 0){
						world.getBlockAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)).setTypeId(31);
						blocks++;
					}
				}
			}
		}
		
		
		
		player.sendMessage(ChatColor.DARK_GREEN + "[TameGrass] " + ChatColor.GREEN + "Long grass spawned on " + ChatColor.AQUA + blocks + ChatColor.GREEN + " blocks!");
		
		if(radius > 200){
		server.dispatchCommand((CommandSender) player, "save-all");
		}
	}

	@SuppressWarnings("static-access")
	private void setupPermissions() {
      Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
      PluginDescriptionFile pdfFile = getDescription();
		version =  pdfFile.getVersion();
      if (this.permissionHandler == null) {
          if (permissionsPlugin != null) {
              this.permissionHandler = ((Permissions) permissionsPlugin).getHandler();
              hasPermissions = true;
              log.info(logPrefix + "v" + version +" - Permissions support enabled for MultiGod");
          } else {
              //log.info("Permission system not detected, defaulting to OP");
          }
      }
	}
	
	//public static Thread executeThread = new Thread();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if( (hasPermissions && permissionHandler.has(player, "tamer.tamegrass")) || player.isOp()){
			if(label.equalsIgnoreCase("tamegrass") || label.equalsIgnoreCase("tg")){
				if(args.length == 1){
					int radius;
					try{
						radius = Integer.parseInt(args[0]);
						notifcount = 0;
						if(radius < 0){
							player.sendMessage(ChatColor.DARK_GREEN + "[TameGrass] " + ChatColor.RED + "The radius must be larger than 0!");
							return true;
						}
						if(radius > 1000){
							player.sendMessage(ChatColor.DARK_GREEN + "[TameGrass] " + ChatColor.RED + "The radius cannot be larger than 1000!");
							return true;
						}
						/*executeThread = new Thread(new TamingThread(player, radius, player.getWorld()));
						executeThread.start();*/
						tamegrass(player, radius, player.getWorld(), player.getLocation());
						return true;
					} catch (NumberFormatException ex){
						ex.printStackTrace();
					}
				}
				return true;
			}
		}
		
		if( (hasPermissions && permissionHandler.has(player, "tamer.spawngrass")) || player.isOp()){
			if(label.equalsIgnoreCase("spawngrass") || label.equalsIgnoreCase("sg")){
				if(args.length == 1){
					int radius;
					try{
						radius = Integer.parseInt(args[0]);
						notifcount = 0;
						if(radius < 0){
							player.sendMessage(ChatColor.DARK_GREEN + "[TameGrass] " + ChatColor.RED + "The radius must be larger than 0!");
							return true;
						}
						if(radius > 1000){
							player.sendMessage(ChatColor.DARK_GREEN + "[TameGrass] " + ChatColor.RED + "The radius cannot be larger than 1000!");
							return true;
						}
						/*executeThread = new Thread(new TamingThread(player, radius, player.getWorld()));
						executeThread.start();*/
						spawngrass(player, radius, player.getWorld(), player.getLocation());
						return true;
					} catch (NumberFormatException ex){
						ex.printStackTrace();
						return true;
					}
				}
				return true;
			}
		}
		
		return false;
	}

}
