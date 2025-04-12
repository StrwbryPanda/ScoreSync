package StrwbryDev.scoreSync.listeners;

import StrwbryDev.scoreSync.ScoreSync;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

public class ListenerManager {
    private static PlayerBedFailEnterListener bedFailListener;
    private static EnderDragonDeathListener enderDragonDeathListener;
    private static PlayerDeathListener playerDeathListener;

    public static void initializeFirstToKillListeners() {
        if (bedFailListener == null) {
            bedFailListener = new PlayerBedFailEnterListener();
            Bukkit.getPluginManager().registerEvents(bedFailListener, ScoreSync.getPlugin());
        }
        if (enderDragonDeathListener == null) {
            enderDragonDeathListener = new EnderDragonDeathListener();
            Bukkit.getPluginManager().registerEvents(enderDragonDeathListener, ScoreSync.getPlugin());
        }
    }
    public static void initializePlayerDeathListener() {
        if (playerDeathListener == null) {
            playerDeathListener = new PlayerDeathListener();
            Bukkit.getPluginManager().registerEvents(playerDeathListener, ScoreSync.getPlugin());
        }
    }

    public static void unregisterFirstToKillListeners() {
        if (bedFailListener != null) {
            HandlerList.unregisterAll(bedFailListener);
            bedFailListener = null;
        }
        if (enderDragonDeathListener != null) {
            HandlerList.unregisterAll(enderDragonDeathListener);
            enderDragonDeathListener = null;
        }
    }
    public static void unregisterPlayerDeathListener() {
        if (playerDeathListener != null) {
            HandlerList.unregisterAll(playerDeathListener);
            playerDeathListener = null;
        }
    }

    public static PlayerBedFailEnterListener getBedFailListener() {
        return bedFailListener;
    }
    public static EnderDragonDeathListener getEntityDeathListener() {
        return enderDragonDeathListener;
    }
    public static PlayerDeathListener getPlayerDeathListener() {
        return playerDeathListener;
    }
}
