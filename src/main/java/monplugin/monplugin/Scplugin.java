package monplugin.monplugin;

import monplugin.monplugin.Commands.BiomeCommand;
import monplugin.monplugin.Commands.DefiCommand;
import monplugin.monplugin.Commands.TestCommand;
import monplugin.monplugin.events.Generator;
import monplugin.monplugin.events.InvEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Scplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin de Scientyst ok!");
        Bukkit.getPluginManager().registerEvents(new Bonjour(),this);
        getCommand("defi").setExecutor(new DefiCommand());
        getCommand("biome").setExecutor(new BiomeCommand());
        getCommand("test").setExecutor(new TestCommand());
        getServer().getPluginManager().registerEvents(new InvEvents(),this);
        getServer().getPluginManager().registerEvents(new Generator(),this);
        Customcraft.init();
    }

    @Override
    public void onDisable() {
        System.out.println("ScPlugin: SO LOOOOOONG!");
        // Plugin shutdown logic
    }
}
