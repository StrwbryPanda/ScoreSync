package StrwbryDev.scoreSync.commands.track;

import StrwbryDev.scoreSync.ScoreSync;
import StrwbryDev.scoreSync.listeners.EntityDeathListener;
import StrwbryDev.scoreSync.listeners.PlayerDeathListener;
import StrwbryDev.scoreSync.utility.MsgUtil;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.concurrent.CompletableFuture;

import static org.bukkit.Bukkit.getServer;

public class CommandFirstToKill
{
    public static LiteralCommandNode<CommandSourceStack> buildCommand(final String commandName) {
        return Commands.literal(commandName)
                .executes(CommandFirstToKill::executeCommandLogic)
                    .build();
    }

    private static CompletableFuture<Suggestions> getCommandSuggestions(final CommandContext<CommandSourceStack> ctx, final SuggestionsBuilder builder) {
        builder.suggest("temp");
        return builder.buildFuture();
    }
    private static int executeCommandLogic(CommandContext<CommandSourceStack> ctx){
        CommandSender sender = ctx.getSource().getSender(); // Retrieve the command sender
        Entity executor = ctx.getSource().getExecutor(); // Retrieve the command executor, which may or may not be the same as the sender

        // Check whether the executor is a player
        if (!(executor instanceof Player player)) {
            // If a non-player tried to execute command
            MsgUtil.warning("First To Kill command from console");
            return Command.SINGLE_SUCCESS;
        }

        //Execute command logic
        getServer().getPluginManager().registerEvents(new EntityDeathListener(), ScoreSync.getPlugin());
        ScoreSync.getScoreTracker().generatePlayerScoreTracker();
        ScoreSync.getWinConditionManager().setAlivePlayers();

        MsgUtil.message(sender,"Successfully used first to kill command!");
        return Command.SINGLE_SUCCESS;

    }
}
