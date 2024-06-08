package monplugin.monplugin.inventories;

import org.bukkit.Material;

import java.util.ArrayList;

public class GuiMine extends InvVide{
    public GuiMine(){
        super("Mine");

        ArrayList<String> descrip=new ArrayList<>();
        descrip.add("§7miner de la cobble");
        descrip.add("64 de cobble pour 2 de dirt");
        setItemAt(Material.COBBLESTONE,"cobble",3,descrip);
        descrip.clear();


    }

}
