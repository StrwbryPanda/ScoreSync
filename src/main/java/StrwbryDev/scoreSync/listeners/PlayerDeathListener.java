package StrwbryDev.scoreSync.listeners;

import StrwbryDev.scoreSync.ScoreSync;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class PlayerDeathListener implements Listener
{


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        ScoreSync.getWinConditionManager().removePlayer(player, ScoreSync.getLastPlayerStanding());
    }


}
