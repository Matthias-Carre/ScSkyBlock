package monplugin.monplugin.events;


import monplugin.monplugin.inventories.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Jukebox;
import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InvEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getClickedInventory()==null){return;}
        else if(e.getClickedInventory().getHolder() instanceof InvVide){ //si je vais une classe qui hérite il faut celle du dessus
            e.setCancelled(true);
            //if(e.isLeftClick())
            Player player = (Player) e.getWhoClicked();
            if(e.getCurrentItem()==null){return;}
            if(e.getCurrentItem().getType()==Material.BARRIER){
                System.out.println("Close");
                player.closeInventory();
            }
            if(e.getCurrentItem().getType()==Material.PINK_GLAZED_TERRACOTTA){
                retour(e,player);
            }
            if(e.getSlot()>=0 || e.getSlot()>26){ //(e.getCurrentItem().getType() == Material.BOOK)
                String categorie = ((InvVide) (e.getClickedInventory().getHolder())).getNom();

                System.out.println(categorie);
                switch (categorie){
                    case "Home":
                        choixHome(e.getCurrentItem().getType(),player);
                        break;
                    case "Defis":
                        choixDefi(e.getCurrentItem().getType(),player);
                        break;
                    case "Nature":
                        player.sendMessage("tu as choisi un truc dans nature");
                        break;
                    case "Mine":
                        choixMine(e.getCurrentItem().getType(),player);
                        break;
                    case "Biomes":
                        choixBiome(e.getCurrentItem().getType(),player);
                        break;
                }

                if(e.getSlot()==1){player.sendMessage("youpi");}
            }
        }
    }
    private void choixDefi(Material m,Player p){
        System.out.println(m);
        InvVide gui;
        switch (m){
            case OAK_SAPLING:
                gui= new GuiNature();
                p.openInventory(gui.getInventory());
                break;
            case COBBLESTONE:
                gui= new GuiMine();
                p.openInventory(gui.getInventory());
                break;
        }
    }
    private void choixMine(Material m , Player p){
        System.out.println(m);
        switch (m){
            case COBBLESTONE:
                if(p.getInventory().contains(Material.COBBLESTONE,64)){
                    p.sendMessage("vous avez échangé 64 cobble contre 2 dirt");
                    ItemStack item = new ItemStack(Material.COBBLESTONE,64);
                    p.getInventory().removeItem(item); //remove(Material.COBBLESTONE);
                    item = new ItemStack(Material.DIRT,2);
                    p.getInventory().addItem(item);
                }else{
                    p.sendMessage("Nombre de cobble insuffisant");
                }

        }
    }
    private void choixHome(Material m,Player p){
        switch (m){
            case GRASS_BLOCK:
                p.openInventory(new GuiBiomes().getInventory());
                break;
            case WRITABLE_BOOK:
                p.openInventory(new GuiDefis().getInventory());
                break;
        }
    }
    private void choixBiome(Material m,Player p){
        switch (m){
            case SPRUCE_SAPLING:
                p.getWorld().setBiome(p.getLocation(), Biome.SNOWY_TAIGA);

                String cmd="execute at "+p.getName()+" run fillbiome ~10 ~10 ~10 ~-10 ~-10 ~-10 minecraft:snow_taiga";
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                System.out.println("biome changé");
                break;
            case JUNGLE_SAPLING:
                p.getLocation().getChunk().getX();
                int x=(int) p.getLocation().getX();
                int y=(int) p.getLocation().getY();
                int z=(int) p.getLocation().getZ();
                System.out.println("On change debut");

                for(int i=x-10;i<x+10;i++){
                    for(int j=y-10;j<y+10;j++){
                        for(int k=z-10;k<z+10;k++){
                            p.getWorld().setBiome(i,j,k,Biome.JUNGLE);

                        }
                    }
                }

                System.out.println("biome changé");
                break;
        }
    }
    private void retour(InventoryClickEvent e,Player p){
        String categorie = ((InvVide) (e.getClickedInventory().getHolder())).getNom();
        switch(categorie){
            case "Biomes":
            case "Defis":
                p.openInventory(new GuiHome().getInventory());
                break;
            case "Nature":
            case "Mine":
                p.openInventory(new GuiDefis().getInventory());
                break;
        }
    }
}
