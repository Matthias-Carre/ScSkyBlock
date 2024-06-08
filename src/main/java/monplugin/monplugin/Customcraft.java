package monplugin.monplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

public class Customcraft {
    public static void init(){CreateGrass();}
    private static void CreateGrass(){

        /*
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("GrassBlock"),new ItemStack(Material.GRASS_BLOCK,1));
        sr.shape(" G "," D ","   ");
        sr.setIngredient('D',Material.DIRT);
        sr.setIngredient('G',Material.GRASS);

        */
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("scgrassblock"),new ItemStack(Material.GRASS_BLOCK,1));
        slr.addIngredient(1,Material.DIRT);
        slr.addIngredient(1,Material.GRASS);
        Bukkit.getServer().addRecipe(slr);
        System.out.println("Craft bien add");
    }



}
