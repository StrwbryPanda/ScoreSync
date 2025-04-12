package StrwbryDev.scoreSync.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;

import java.util.concurrent.CompletableFuture;

public class CommandRootScoreSync
{
    public static LiteralCommandNode<CommandSourceStack> buildCommand()
    {
        return Commands.literal("scoresync")
                //.then(Commands.literal(CommandHelp.buildCommand()))
                .then(CommandTrack.buildCommand("track"))
                .then(CommandReloadConfig.buildCommand("reloadconfig"))
                .then(CommandDisplayScores.buildCommand("displayscores"))
                .then(Commands.argument("subcommands", StringArgumentType.word())
                        .suggests(CommandRootScoreSync::getCommandSuggestions)
                )
                .build();
    }
    private static CompletableFuture<Suggestions> getCommandSuggestions(final CommandContext<CommandSourceStack> ctx, final SuggestionsBuilder builder) {
//        builder.suggest("help");
        builder.suggest("track");
        builder.suggest("reloadconfig");
        builder.suggest("displayscores");
        return builder.buildFuture();
    }
}
