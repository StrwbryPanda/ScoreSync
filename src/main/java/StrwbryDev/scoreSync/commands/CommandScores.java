package StrwbryDev.scoreSync.commands;

import StrwbryDev.scoreSync.commands.score.CommandDisplay;
import StrwbryDev.scoreSync.commands.score.CommandReset;
import StrwbryDev.scoreSync.commands.score.CommandSet;
import StrwbryDev.scoreSync.commands.score.display.CommandAll;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;

import java.util.concurrent.CompletableFuture;

public class CommandScores
{
    public static LiteralCommandNode<CommandSourceStack> buildCommand(final String commandName)
    {
        return Commands.literal(commandName)
                .then(CommandDisplay.buildCommand("display"))
//                .then(CommandAdd.buildCommand("add"))
//                .then(CommandSet.buildCommand("set"))
//                .then(CommandReset.buildCommand("reset"))
                .then(Commands.argument("subcommands", StringArgumentType.word())
                        .suggests(CommandScores::getCommandSuggestions)
                )
                .build();
    }
    private static CompletableFuture<Suggestions> getCommandSuggestions(final CommandContext<CommandSourceStack> ctx, final SuggestionsBuilder builder) {
//        builder.suggest("help");
        builder.suggest("display");
//        builder.suggest("add");
//        builder.suggest("set");
//        builder.suggest("reset");
        return builder.buildFuture();
    }
}
