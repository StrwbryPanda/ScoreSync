package StrwbryDev.scoreSync.conditions;

import StrwbryDev.scoreSync.utility.MsgUtil;
import org.bukkit.entity.Player;

public class FirstToKill extends WinCondition
{

    @Override
    public void handleWinCondition(Player player)
    {
        MsgUtil.broadcast(player.getName() + "has slain the ender dragon!");

    }
}
