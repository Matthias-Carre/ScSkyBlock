package monplugin.monplugin.Commands;


import monplugin.monplugin.inventories.GuiBiomes;
import monplugin.monplugin.inventories.GuiDefis;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DefiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("seul les joueurs peuvent utilisé cette commande!");
            return true;
        }
        Player player=(Player) sender;
        if(cmd.getName().equalsIgnoreCase("defi")){
            GuiDefis gui = new GuiDefis();
            player.openInventory(gui.getInventory());
            player.sendMessage(ChatColor.BLUE+"menu des défis ouvert");
        }

        return true;
    }
}
