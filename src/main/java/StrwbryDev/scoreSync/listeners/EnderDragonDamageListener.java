package StrwbryDev.scoreSync.listeners;

import StrwbryDev.scoreSync.ScoreSync;
import StrwbryDev.scoreSync.utility.MsgUtil;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EnderDragonDamageListener implements Listener
{

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e){
        DamageSource damageSource = e.getDamageSource();
        if (e.getEntity() instanceof EnderDragon) {
            if (damageSource.getCausingEntity() instanceof Player player) {
                ScoreSync.getFirstToKill().addAssistCredit(player);
                MsgUtil.broadcast(player.getName() + " has damaged the ender dragon!");
            }
            if(damageSource.getDamageType().equals(DamageType.BAD_RESPAWN_POINT)) {
                ScoreSync.getFirstToKill().addAssistCredit(ListenerManager.getBedFailListener().getPlayer());
            }
        }
    }


}
