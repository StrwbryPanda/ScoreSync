package StrwbryDev.scoreSync.commands.score;

import StrwbryDev.scoreSync.commands.CommandTrack;
import StrwbryDev.scoreSync.commands.score.player.CommandPlayer;
import StrwbryDev.scoreSync.commands.track.CommandFirstToKill;
import StrwbryDev.scoreSync.commands.track.CommandLastPlayerStanding;
import StrwbryDev.scoreSync.commands.track.CommandStop;
import com.mojang.brigadier.arguments.ArgumentType;
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
@SuppressWarnings("UnstableApiUsage")
public class CommandReset
{
    @NullMarked
    public static LiteralCommandNode<CommandSourceStack> buildCommand(final String commandName)
    {
        return Commands.literal(commandName)
                .requires(sender -> sender.getSender().isOp())
                .then(CommandLastPlayerStanding.buildCommand("*"))
                .then(Commands.argument("players", StringArgumentType.word())
                        .suggests(CommandReset::getCommandSuggestions))
                .then(Commands.argument("subcommands", StringArgumentType.word())
                        .suggests(CommandReset::getCommandSuggestions)
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
///scoresync scores add [playername] [int score]