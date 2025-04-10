package StrwbryDev.scoreSync.listeners;

import StrwbryDev.scoreSync.ScoreSync;
import org.bukkit.Location;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scoreboard.Team;

import java.util.UUID;

public class EntityDeathListener
{
    @SuppressWarnings("UnstableApiUsage")
    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {

            DamageSource ds = e.getDamageSource();

            if (ds.getCausingEntity() instanceof Player p) {
                //call first to kill logic

            }
            // check for bed explosion or other damage types
        }
    }
