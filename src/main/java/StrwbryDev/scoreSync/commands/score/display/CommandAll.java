package StrwbryDev.scoreSync.commands.score.display;

import StrwbryDev.scoreSync.ScoreSync;
import StrwbryDev.scoreSync.utility.MsgUtil;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.command.CommandSender;

public class CommandAll
{
    public static LiteralCommandNode<CommandSourceStack> buildCommand(final String commandName) {
        return Commands.literal(commandName)
                .requires(sender -> sender.getSender().isOp())
                .executes(CommandAll::executeCommandLogic)
                .build();
    }

    private static int executeCommandLogic(CommandContext<CommandSourceStack> ctx){
        CommandSender sender = ctx.getSource().getSender(); // Retrieve the command sender

        //Execute command logic
        ScoreSync.getScoreTracker().getSortedPlayerScores();
        ScoreSync.getScoreTracker().getPlayerScores().forEach((player, score) -> {
            MsgUtil.message(sender,player.getName() + ": " + score);
        });

//        MsgUtil.message(sender,"Successfully used first to kill command!");
        return Command.SINGLE_SUCCESS;

    }
}
