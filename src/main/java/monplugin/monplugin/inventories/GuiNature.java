package monplugin.monplugin.inventories;

import org.bukkit.Material;

import java.util.ArrayList;

public class GuiNature extends InvVide{
    public GuiNature(){
        super("Nature");

        ArrayList<String> descrip=new ArrayList<>();
        descrip.add("§7récolte du Blé");
        descrip.add("Récolté 64 de blé");
        setItemAt(Material.WHEAT,"Blé",3,descrip);
        descrip.clear();

        descrip.add("§7récolte des carottes");
        descrip.add("Récolté 64 de carottes");
        setItemAt(Material.CARROT,"Carottes",4,descrip);
        descrip.clear();

        descrip.add("§7récolte du patate");
        descrip.add("Récolté 64 de patate");
        setItemAt(Material.POTATO,"Patate",5,descrip);
        descrip.clear();

        descrip.add("§7récolte du Bétraves");
        descrip.add("Récolté 64 de Bétraves");
        setItemAt(Material.BEETROOT,"Bétraves",13,descrip);
        descrip.clear();

        descrip.add("§7récolte du Cactus");
        descrip.add("Récolté 64 de Cactus");
        setItemAt(Material.CACTUS,"Cactus",14,descrip);
        descrip.clear();

    }

}
