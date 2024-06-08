package monplugin.monplugin.inventories;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class GuiBiomes extends InvVide{

    public  GuiBiomes(){
        super("Biomes");

        ArrayList<String> des = new ArrayList<String>();
        des.add("Changé pour un biome Jungle");
        setItemAt(Material.JUNGLE_SAPLING,"Jungle",3, des);

        des.clear();
        des.add("changé pour un biome cold taiga");
        setItemAt(Material.SPRUCE_SAPLING,"Cold Taiga",4, des);
    }
}
