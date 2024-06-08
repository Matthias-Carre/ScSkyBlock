package monplugin.monplugin.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.event.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockFromToEvent;

public class Generator implements Listener {

    @EventHandler
    public void onFromTo(BlockFromToEvent event) {

        Material type = event.getBlock().getType();

        //System.out.println(event.getBlock().getBlockData() instanceof Waterlogged);
        /*Test pour les géné avec waterloged
        if(event.getBlock().getBlockData() instanceof Waterlogged) { //Check for waterlogged block
            type=Material.WATER;
            System.out.println("waterlog");
        }
        */

        if (type == Material.WATER || type == Material.LEGACY_WATER || type == Material.LAVA || type == Material.LEGACY_LAVA) {
            Block b = event.getToBlock();
            if (b.getType() == Material.AIR) {
                if (generatesCobble(type, b)) {

                    event.setCancelled(true);
                    b.setType(Material.IRON_BLOCK);
                    /* DO WHATEVER YOU NEED WITH THE COBBLE */
                    //event.setCancelled(true);
                }
            }
        }
    }

    private final BlockFace[] faces = new BlockFace[]{
            BlockFace.SELF,
            BlockFace.UP,
            BlockFace.DOWN,
            BlockFace.NORTH,
            BlockFace.EAST,
            BlockFace.SOUTH,
            BlockFace.WEST
    };

    public boolean generatesCobble(Material type, Block b) {
        Material mirrorID1 = (type == Material.WATER || type == Material.LEGACY_WATER ? Material.LAVA : Material.WATER);
        Material mirrorID2 = (type == Material.WATER || type == Material.LEGACY_WATER ? Material.LEGACY_LAVA : Material.LEGACY_WATER);
        for (BlockFace face : faces) {
            Block r = b.getRelative(face, 1);
            if (r.getType() == mirrorID1 || r.getType() == mirrorID2) {
                return true;
            }
        }
        return false;
    }
}