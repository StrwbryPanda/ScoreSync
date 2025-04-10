package StrwbryDev.scoreSync;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class ScoreTracker
{
    private final HashMap<Player, Integer> playerScores = new HashMap<>();

    public ScoreTracker()
    {
    }

    public boolean generatePlayerScoreTracker()
    {
        if(playerScores.size() > 0) {
            return false;
        }
        List<Player> onlinePlayers = new ArrayList<>(getServer().getOnlinePlayers());
        for (Player player : onlinePlayers)
        {
            playerScores.put(player, 0);
        }
        return true;
    }

    public boolean addPlayerScore(Player player, int score)
    {
        if (!playerScores.containsKey(player))
        {
            return false;
        }
        playerScores.put(player, playerScores.get(player) + score);
        return true;
    }

    public void clearScoreTracker()
    {
        playerScores.clear();
    }

    public HashMap<Player, Integer> getPlayerScores()
    {
        return playerScores;
    }
    public int getPlayerScore(Player player)
    {
        return playerScores.getOrDefault(player, 0);
    }
}
