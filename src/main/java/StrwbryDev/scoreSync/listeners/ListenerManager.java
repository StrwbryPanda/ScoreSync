package StrwbryDev.scoreSync.listeners;

import StrwbryDev.scoreSync.ScoreSync;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

public class ListenerManager {
    private static PlayerBedFailEnterListener bedFailListener;
    private static EntityDeathListener entityDeathListener;
    private static PlayerDeathListener playerDeathListener;

    public static void initializeFirstToKillListeners() {
        if (bedFailListener == null) {
            bedFailListener = new PlayerBedFailEnterListener();
            Bukkit.getPluginManager().registerEvents(bedFailListener, ScoreSync.getPlugin());
        }
        if (entityDeathListener == null) {
            entityDeathListener = new EntityDeathListener();
            Bukkit.getPluginManager().registerEvents(entityDeathListener, ScoreSync.getPlugin());
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
        if (entityDeathListener != null) {
            HandlerList.unregisterAll(entityDeathListener);
            entityDeathListener = null;
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
    public static EntityDeathListener getEntityDeathListener() {
        return entityDeathListener;
    }
    public static PlayerDeathListener getPlayerDeathListener() {
        return playerDeathListener;
    }
}
