package StrwbryDev.scoreSync.commands.track;

import StrwbryDev.scoreSync.listeners.ListenerManager;
import StrwbryDev.scoreSync.utility.MsgUtil;
import StrwbryDev.scoreSync.ScoreSync;
import StrwbryDev.scoreSync.listeners.PlayerDeathListener;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

import static org.bukkit.Bukkit.getServer;

public class CommandLastPlayerStanding
{
    public static LiteralCommandNode<CommandSourceStack> buildCommand(final String commandName) {
        return Commands.literal(commandName)
                .requires(sender -> sender.getSender().isOp())
                .executes(CommandLastPlayerStanding::executeCommandLogic)
                .build();
    }

    private static int executeCommandLogic(CommandContext<CommandSourceStack> ctx){
        CommandSender sender = ctx.getSource().getSender(); // Retrieve the command sender


        //Execute command logic
        ListenerManager.initializePlayerDeathListener();
        ScoreSync.getScoreTracker().generatePlayerScoreTracker();
        ScoreSync.getWinConditionManager().setAlivePlayers();

        MsgUtil.message(sender,"Successfully used lps command!");
        return Command.SINGLE_SUCCESS;

    }

}
