package StrwbryDev.scoreSync.commands.track;

import StrwbryDev.scoreSync.listeners.ListenerManager;
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
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

public class CommandSample
{
    //builds the command
    //allows setting of permissions, subcommands, etc.
    public static LiteralCommandNode<CommandSourceStack> buildCommand(final String commandName) {
        return Commands.literal(commandName)
                .requires(sender -> sender.getSender().isOp())
                .executes(CommandSample::executeCommandLogic)
                .build();
    }

    //tab completion options for any subcommands
    private static CompletableFuture<Suggestions> getCommandSuggestions(final CommandContext<CommandSourceStack> ctx, final SuggestionsBuilder builder) {
        builder.suggest("samplesubcommand");
        return builder.buildFuture();
    }

    private static int executeCommandLogic(CommandContext<CommandSourceStack> ctx){
        CommandSender sender = ctx.getSource().getSender(); // Retrieve the command sender
        Entity executor = ctx.getSource().getExecutor(); // Retrieve the command executor, which may or may not be the same as the sender

        // Check whether the executor is a player
        // can use this to block commands being run from the console
        if (!(executor instanceof Player player)) {
            // If a non-player tried to execute command
            MsgUtil.warning("sample command from console");
            return Command.SINGLE_SUCCESS;
        }

        //Execute command logic here



        MsgUtil.message(sender,"Successfully used sample command!");
        return Command.SINGLE_SUCCESS;

    }
}
