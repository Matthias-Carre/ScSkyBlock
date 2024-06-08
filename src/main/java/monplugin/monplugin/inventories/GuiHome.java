package monplugin.monplugin.inventories;

import org.bukkit.Color;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Collections;

public class GuiHome extends InvVide{
    public GuiHome(){
        super("Home");
        this.inv.setItem(25,createItem("", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList("")));

        ArrayList<String> descrip=new ArrayList<>();

        descrip.add("Changé le Biome");
        setItemAt(Material.GRASS_BLOCK,"Biomes",11,descrip);
        descrip.clear();

        descrip.add("Liste des defis");
        setItemAt(Material.WRITABLE_BOOK,"Défis",13,descrip);
        descrip.clear();

        descrip.add("AUTRE");
        setItemAt(Material.LIGHT,"comingsoon",15,descrip);
    }
}
