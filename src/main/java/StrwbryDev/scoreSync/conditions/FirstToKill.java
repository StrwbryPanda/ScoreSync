package StrwbryDev.scoreSync.conditions;

import StrwbryDev.scoreSync.listeners.ListenerManager;
import StrwbryDev.scoreSync.utility.MsgUtil;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class FirstToKill extends WinCondition
{
    Collection<Player> assistingPlayers;

    public FirstToKill()
    {
        assistingPlayers = new ArrayList<>();
    }

    @Override
    public void handleWinCondition(Player player)
    {
        MsgUtil.broadcast(player.getName() + "has slain the ender dragon!");
        for (Player assistingPlayer : assistingPlayers){
            MsgUtil.broadcast(assistingPlayer.getName() + " assisted in killing the ender dragon!");
        }
        ListenerManager.unregisterFirstToKillListeners();
    }

    public void addAssistCredit(Player player){
        //if assistingPlayers does not already contain player, add player
        if(!assistingPlayers.contains(player)){
            assistingPlayers.add(player);
        }
    }
}
