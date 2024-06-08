package monplugin.monplugin.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class GuiTest implements InventoryHolder {
    Inventory inv;

    public GuiTest(){
        inv = Bukkit.createInventory(this,1,"oué");
        inv.setItem(0,new ItemStack(Material.OAK_PLANKS));
    }
    @Override
    public Inventory getInventory() {
        return this.inv;
    }
}
