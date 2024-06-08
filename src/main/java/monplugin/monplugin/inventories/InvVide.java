package monplugin.monplugin.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvVide implements InventoryHolder{

    protected Inventory inv;
    String nom;
    public InvVide(String Description){
        inv = Bukkit.createInventory(this,27,Description);
        this.nom=Description;
        init();
    }

    private void init(){
        ItemStack item;
        item = createItem("",Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(""));
        for(int i=0;i<25;i++) {
            inv.setItem(i,item);
        }
        item = createItem("Retour",Material.PINK_GLAZED_TERRACOTTA, Collections.singletonList("Retour"));
        inv.setItem(25,item);

        item = createItem("Quitté",Material.BARRIER, Collections.singletonList("Quitté"));
        inv.setItem(26,item);
    }


    protected ItemStack createItem(String name, Material mat, List<String> lore){
        ItemStack item = new ItemStack(mat,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
    protected void setItemAt(Material mat,String nom,int n,ArrayList<String> des){
        ItemStack item = createItem(nom,mat,des);
        inv.setItem(n,item);
    }
    @Override
    public Inventory getInventory() {
        return inv;
    }
    public String getNom(){return this.nom;}
}
