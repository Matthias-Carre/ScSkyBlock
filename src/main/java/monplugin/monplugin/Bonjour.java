package monplugin.monplugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static org.bukkit.Material.*;

public class Bonjour implements Listener {
    @EventHandler
    public void test(BlockPlaceEvent e){
        //System.out.println(e.getBlock().getX());
        Block b1 = e.getBlockPlaced();
        Block b2 = e.getBlockAgainst();
        Material type = b1.getType();
        if(b1.getType() == DIAMOND_BLOCK){
            System.out.println("pose un block de diams");
            if(b2.getType()==IRON_BLOCK){
                System.out.println("MAGIIIE");
                b1.setType(AIR);
                b2.setType(COAL_BLOCK);
            }
        }


    }
}
