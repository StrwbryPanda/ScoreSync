package StrwbryDev.scoreSync.listeners;

import io.papermc.paper.event.player.PlayerBedFailEnterEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerBedFailEnterListener implements Listener
{
    private Player player;

    public PlayerBedFailEnterListener() {
        this.player = null;
    }
    @EventHandler
    public void onPlayerBedFailEnter(PlayerBedFailEnterEvent e) {

        player = e.getPlayer();
    }

    public Player getPlayer() {
        return player;
    }
}
