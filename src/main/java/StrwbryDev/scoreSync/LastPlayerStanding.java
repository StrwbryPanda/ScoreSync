package StrwbryDev.scoreSync;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class LastPlayerStanding
{
    private static final int winThreshold1 = 10;
    private static final int winThreshold2 = 20;
    private static final int winThreshold3 = 30;

    public List<Player> alivePlayers;

    public LastPlayerStanding() {
        alivePlayers = new ArrayList<>();

    }
    public void checkWinThreshold(Player player){
        int totalOnlinePlayers =  ScoreSync.getScoreTracker().getPlayerScores().size();
        // Get remaining players count
        int remainingPlayers = alivePlayers.size();

        // Award points based on thresholds
        if (remainingPlayers <= winThreshold1) {
            MsgUtil.message(player,"Top 10% reached - awarding 3 points");
            ScoreSync.getScoreTracker().addPlayerScore(player, 3);
            MsgUtil.message(player, "Score: " + ScoreSync.getScoreTracker().getPlayerScore(player));
            return;
        }

        if (remainingPlayers <= winThreshold2) {
            MsgUtil.message(player,"Top 20% reached - awarding 2 points");
            ScoreSync.getScoreTracker().addPlayerScore(player, 2);
            return;
        }

        if (remainingPlayers <= winThreshold3) {
            MsgUtil.message(player,"Top 30% reached - awarding 1 point");
            ScoreSync.getScoreTracker().addPlayerScore(player, 1);
        }
    }
    public void removePlayer(Player player) {
        alivePlayers.remove(player);
        checkWinThreshold(player);
    }
    public void populateAlivePlayers() {
        alivePlayers.clear();
        alivePlayers.addAll(getServer().getOnlinePlayers());
    }
}
