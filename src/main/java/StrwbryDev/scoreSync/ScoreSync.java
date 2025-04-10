package StrwbryDev.scoreSync;

import StrwbryDev.scoreSync.commands.CommandRootScoreSync;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class ScoreSync extends JavaPlugin
{
    private static ScoreSync plugin;
    private static ScoreTracker scoreTracker;
    private static LastPlayerStanding lastPlayerStanding;
    @Override
    public void onEnable()
    {
        // Plugin startup logic
        plugin = this;
        scoreTracker = new ScoreTracker();
        lastPlayerStanding = new LastPlayerStanding();


        saveResource("config.yml", /* replace */ false);

        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register(CommandRootScoreSync.buildCommand());
        });

    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
    public static ScoreSync getPlugin()
    {
        return plugin;
    }
    public static ScoreTracker getScoreTracker()
    {
        return scoreTracker;
    }
    public static LastPlayerStanding getLastPlayerStanding()
    {
        return lastPlayerStanding;
    }
}
