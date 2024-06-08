package monplugin.monplugin.inventories;


import org.bukkit.Material;
import java.util.ArrayList;
import java.util.Collections;

public class GuiDefis extends InvVide {

    public GuiDefis(){

        super("Defis");


        ArrayList<String> descrip=new ArrayList<>();
        descrip.add("§7Nature");
        descrip.add("§bMission pour les plantes");
        setItemAt(Material.OAK_SAPLING,"Nature",3,descrip);

        descrip.clear();
        descrip.add("Mission de minage");
        setItemAt(Material.COBBLESTONE,"Mine",4,descrip);

    }


}
