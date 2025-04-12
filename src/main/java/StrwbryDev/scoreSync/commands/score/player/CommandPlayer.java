package StrwbryDev.scoreSync.commands.score.player;

import StrwbryDev.scoreSync.commands.score.CommandReset;
import StrwbryDev.scoreSync.commands.track.CommandLastPlayerStanding;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

public class CommandPlayer
{
    @NullMarked
    public static LiteralCommandNode<CommandSourceStack> buildCommand(final String commandName)
    {
        return Commands.literal(commandName)
                .requires(sender -> sender.getSender().isOp())
                .then(CommandLastPlayerStanding.buildCommand("*"))
                .then(CommandPlayer.buildCommand("player"))
                .then(Commands.argument("subcommands", StringArgumentType.word())
                        .suggests(CommandPlayer::getCommandSuggestions)
                )
                .build();
    }
    private static CompletableFuture<Suggestions> getCommandSuggestions(final CommandContext<CommandSourceStack> ctx, final SuggestionsBuilder builder) {
        builder.suggest("*");
        for(Player player : ctx.getSource().getSender().getServer().getOnlinePlayers()) {
            builder.suggest(player.getName());
        }
        return builder.buildFuture();
    }
}
