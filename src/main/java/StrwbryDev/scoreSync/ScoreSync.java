package StrwbryDev.scoreSync;

import StrwbryDev.scoreSync.commands.CommandRootScoreSync;
import StrwbryDev.scoreSync.conditions.FirstToKill;
import StrwbryDev.scoreSync.conditions.LastPlayerStanding;
import StrwbryDev.scoreSync.conditions.WinConditionManager;
import StrwbryDev.scoreSync.listeners.PlayerBedFailEnterListener;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class ScoreSync extends JavaPlugin
{
    private static ScoreSync plugin;
    private static WinConditionManager winConditionManager;
    private static ScoreTracker scoreTracker;
    private static LastPlayerStanding lastPlayerStanding;
    private static FirstToKill firstToKill;

    @Override
    public void onEnable()
    {
        // Plugin startup logic
        plugin = this;
        winConditionManager = new WinConditionManager();
        scoreTracker = new ScoreTracker();
        lastPlayerStanding = new LastPlayerStanding();
        firstToKill = new FirstToKill();


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

    public static WinConditionManager getWinConditionManager()
    {
        return winConditionManager;
    }
    public static FirstToKill getFirstToKill()
    {
        return firstToKill;
    }
}
