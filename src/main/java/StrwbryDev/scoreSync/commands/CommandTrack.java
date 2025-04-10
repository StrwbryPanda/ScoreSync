package StrwbryDev.scoreSync.commands;

import StrwbryDev.scoreSync.commands.track.CommandFirstToKill;
import StrwbryDev.scoreSync.commands.track.CommandLastPlayerStanding;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.command.brigadier.argument.resolvers.selector.PlayerSelectorArgumentResolver;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

public class CommandTrack
{
    @NullMarked
    public static LiteralCommandNode<CommandSourceStack> buildCommand(final String commandName)
    {
        return Commands.literal(commandName)
                .then(CommandFirstToKill.buildCommand("firsttokill"))
                .then(CommandLastPlayerStanding.buildCommand("lastplayerstanding"))
                .then(Commands.argument("subcommands", StringArgumentType.word())
                        .suggests(CommandTrack::getCommandSuggestions)
                )
                .build();
    }
    private static CompletableFuture<Suggestions> getCommandSuggestions(final CommandContext<CommandSourceStack> ctx, final SuggestionsBuilder builder) {
        builder.suggest("firsttokill");
        builder.suggest("lastplayerstanding");
        return builder.buildFuture();
    }
}
