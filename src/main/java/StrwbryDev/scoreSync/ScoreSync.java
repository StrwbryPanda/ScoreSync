package StrwbryDev.scoreSync;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class ScoreSync extends JavaPlugin
{
    private static ScoreSync plugin;
    @Override
    public void onEnable()
    {
        // Plugin startup logic
        plugin = this;
        saveResource("config.yml", /* replace */ false);

        //initializes eventhorizon base command
        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS,
                event -> event.registrar().register("scoresync", new CommandsManager()));

    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
}
