package StrwbryDev.scoreSync.conditions;

import StrwbryDev.scoreSync.ScoreSync;
import StrwbryDev.scoreSync.listeners.ListenerManager;
import StrwbryDev.scoreSync.utility.Config;
import StrwbryDev.scoreSync.utility.MsgUtil;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class FirstToKill extends WinCondition
{
    private Collection<Player> assistingPlayers;
    private final int pointsAwardedLastHit;
    private final int pointsAwardedAssist;

    public FirstToKill()
    {
        assistingPlayers = new ArrayList<>();
        pointsAwardedLastHit = Config.getFTKPointsAwardedLastHit();
        pointsAwardedAssist = Config.getFTKPointsAwardedAssist();
    }

    @Override
    public void handleWinCondition(Player player)
    {
        for (Player p : assistingPlayers)
        {
            if(p!= player) {
                ScoreSync.getScoreTracker().addPlayerScore(p, pointsAwardedAssist);
                MsgUtil.message(p, "You have been awarded " + pointsAwardedAssist + " points for assisting in the kill!");
                MsgUtil.message(p, "Score: " + ScoreSync.getScoreTracker().getPlayerScore(p));
            }
        }
        MsgUtil.broadcast(player.getName() + "has slain the ender dragon!");
        ScoreSync.getScoreTracker().addPlayerScore(player, pointsAwardedLastHit);

        ListenerManager.unregisterFirstToKillListeners();
    }

    public void addAssistCredit(Player player){
        //if assistingPlayers does not already contain player, add player
        if(!assistingPlayers.contains(player)){
            assistingPlayers.add(player);
        }
    }
}
