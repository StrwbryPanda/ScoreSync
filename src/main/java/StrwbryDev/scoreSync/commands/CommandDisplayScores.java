package StrwbryDev.scoreSync.commands;

import StrwbryDev.scoreSync.commands.display.CommandAll;
import StrwbryDev.scoreSync.commands.display.CommandTopTen;
import StrwbryDev.scoreSync.commands.track.CommandFirstToKill;
import StrwbryDev.scoreSync.commands.track.CommandLastPlayerStanding;
import StrwbryDev.scoreSync.commands.track.CommandStop;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

public class CommandDisplayScores
{
    @NullMarked
    public static LiteralCommandNode<CommandSourceStack> buildCommand(final String commandName)
    {
        return Commands.literal(commandName)
                .requires(sender -> sender.getSender().isOp())
                .then(CommandTopTen.buildCommand("topten"))
                .then(CommandAll.buildCommand("all"))
//                .then(CommandPlayer.buildCommand("player"))
                .then(Commands.argument("subcommands", StringArgumentType.word())
                        .suggests(CommandDisplayScores::getCommandSuggestions)
                )
                .build();
    }
    private static CompletableFuture<Suggestions> getCommandSuggestions(final CommandContext<CommandSourceStack> ctx, final SuggestionsBuilder builder) {
        builder.suggest("topten");
        builder.suggest("all");
//        builder.suggest("player");
        return builder.buildFuture();
    }
}
