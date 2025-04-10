package StrwbryDev.scoreSync.conditions;

import StrwbryDev.scoreSync.ScoreSync;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.bukkit.Bukkit.getServer;

public class WinConditionManager
{
    private final Map<WinConditionEnum, WinCondition> conditions = new HashMap<>();
    private static List<Player> alivePlayers = new ArrayList<>();

    public WinConditionManager()
    {

    }

    public List<Player> getAlivePlayers()
    {
        return alivePlayers;
    }
    public void setAlivePlayers()
    {
        alivePlayers.clear();
        alivePlayers.addAll(getServer().getOnlinePlayers());
    }
    public void removePlayer(Player player, WinCondition winCondition) {
        alivePlayers.remove(player);
        winCondition.checkWinThreshold(player);
    }

}
