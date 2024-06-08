package monplugin.monplugin.Commands;

import monplugin.monplugin.inventories.GuiBiomes;
import monplugin.monplugin.inventories.GuiTest;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("seul les joueurs peuvent utilisé cette commande!");
            return true;
        }
        Player player=(Player) sender;
        if(cmd.getName().equalsIgnoreCase("test")){
            GuiTest gui = new GuiTest();
            player.openInventory(gui.getInventory());
            player.sendMessage(ChatColor.BLUE+"menu des tests ouvert");

        }
        return true;
    }
}
