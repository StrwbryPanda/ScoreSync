package StrwbryDev.scoreSync.listeners;

import StrwbryDev.scoreSync.ScoreSync;
import StrwbryDev.scoreSync.utility.MsgUtil;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EnderDragonDeathListener implements Listener
{

    @SuppressWarnings("UnstableApiUsage")
    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        DamageSource damageSource = e.getDamageSource();
        if (e.getEntity() instanceof EnderDragon) {
            MsgUtil.broadcast("Ender Dragon has been slain!");
            if (damageSource.getCausingEntity() instanceof Player player) {
                ScoreSync.getFirstToKill().handleWinCondition(player);
            }
            if(damageSource.getDamageType().equals(DamageType.BAD_RESPAWN_POINT)) {
                ScoreSync.getFirstToKill().handleWinCondition(ListenerManager.getBedFailListener().getPlayer());
            }
        }
    }
}

