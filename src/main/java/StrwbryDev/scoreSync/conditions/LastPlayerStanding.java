package StrwbryDev.scoreSync.conditions;

import StrwbryDev.scoreSync.ScoreSync;
import StrwbryDev.scoreSync.utility.Config;
import StrwbryDev.scoreSync.utility.MsgUtil;
import org.bukkit.entity.Player;

public class LastPlayerStanding extends WinCondition
{
    private final int winThreshold1;
    private final int winThreshold2;
    private final int winThreshold3;
    private final int pointsAwardedLastAlive;
    private final int pointsAwardedTier1;
    private final int pointsAwardedTier2;
    private final int pointsAwardedTier3;



    public LastPlayerStanding() {
        winThreshold1 = Config.getWinThresholdTier1();
        winThreshold2 = Config.getWinThresholdTier2();
        winThreshold3 = Config.getWinThresholdTier3();
        pointsAwardedLastAlive = Config.getLastAlive();
        pointsAwardedTier1 = Config.getLPSPointsAwardedTier1();
        pointsAwardedTier2 = Config.getLPSPointsAwardedTier2();
        pointsAwardedTier3 = Config.getLPSPointsAwardedTier3();
    }
    public void handleWinCondition(Player player){
        int totalOnlinePlayers =  ScoreSync.getScoreTracker().getPlayerScores().size();
        // Get remaining players count
        int remainingPlayers = ScoreSync.getWinConditionManager().getAlivePlayers().size();

        //check if player is last player standing
        if (remainingPlayers == 0) {
            MsgUtil.message(player,"You are the last player standing - awarding 5 points");
            ScoreSync.getScoreTracker().addPlayerScore(player, pointsAwardedLastAlive);
            MsgUtil.message(player, "Score: " + ScoreSync.getScoreTracker().getPlayerScore(player));
            return;
        }

        // Award points based on thresholds
        if (remainingPlayers <= winThreshold1) {
            MsgUtil.message(player,"Top 10% reached - awarding 3 points");
            ScoreSync.getScoreTracker().addPlayerScore(player, pointsAwardedTier1);
            MsgUtil.message(player, "Score: " + ScoreSync.getScoreTracker().getPlayerScore(player));
            return;
        }

        if (remainingPlayers <= winThreshold2) {
            MsgUtil.message(player,"Top 20% reached - awarding 2 points");
            ScoreSync.getScoreTracker().addPlayerScore(player, pointsAwardedTier2);
            MsgUtil.message(player, "Score: " + ScoreSync.getScoreTracker().getPlayerScore(player));
            return;
        }

        if (remainingPlayers <= winThreshold3) {
            MsgUtil.message(player,"Top 30% reached - awarding 1 point");
            ScoreSync.getScoreTracker().addPlayerScore(player, pointsAwardedTier3);
            MsgUtil.message(player, "Score: " + ScoreSync.getScoreTracker().getPlayerScore(player));
        }
    }




}
