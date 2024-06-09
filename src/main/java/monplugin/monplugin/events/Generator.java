package monplugin.monplugin.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.event.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.HashMap;

public class Generator implements Listener {

    HashMap<Material, Integer> probaGenerator = new HashMap<>();
    int[] proba;

    @EventHandler
    public void onBlockForm(BlockFormEvent event) {
        Block block = event.getBlock();
        if(event.getNewState().getType() == Material.COBBLESTONE){
            System.out.println("onBlockForm: Cobbel générer");
            event.setCancelled(true);
            block.setType(Material.IRON_BLOCK);
        }
        if(event.getNewState().getType() == Material.BASALT){
            System.out.println("onBlockForm: Basalt");
            event.setCancelled(true);
            block.setType(Material.IRON_BLOCK);
        }
    }


    public void setProba(){

    }
}