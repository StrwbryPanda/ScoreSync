package StrwbryDev.scoreSync.conditions;

import StrwbryDev.scoreSync.ScoreSync;
import StrwbryDev.scoreSync.utility.MsgUtil;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class LastPlayerStanding extends WinCondition
{
    private static final int winThreshold1 = 10;
    private static final int winThreshold2 = 20;
    private static final int winThreshold3 = 30;



    public LastPlayerStanding() {
    }
    public void checkWinThreshold(Player player){
        int totalOnlinePlayers =  ScoreSync.getScoreTracker().getPlayerScores().size();
        // Get remaining players count
        int remainingPlayers = ScoreSync.getWinConditionManager().getAlivePlayers().size();

        //check if player is last player standing
        if (remainingPlayers == 0) {
            MsgUtil.message(player,"You are the last player standing - awarding 5 points");
            ScoreSync.getScoreTracker().addPlayerScore(player, 5);
            MsgUtil.message(player, "Score: " + ScoreSync.getScoreTracker().getPlayerScore(player));
            return;
        }

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
            MsgUtil.message(player, "Score: " + ScoreSync.getScoreTracker().getPlayerScore(player));
            return;
        }

        if (remainingPlayers <= winThreshold3) {
            MsgUtil.message(player,"Top 30% reached - awarding 1 point");
            ScoreSync.getScoreTracker().addPlayerScore(player, 1);
            MsgUtil.message(player, "Score: " + ScoreSync.getScoreTracker().getPlayerScore(player));
        }
    }




}
