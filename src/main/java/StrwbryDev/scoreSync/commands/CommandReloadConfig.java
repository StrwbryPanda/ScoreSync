package StrwbryDev.scoreSync.commands;

import StrwbryDev.scoreSync.ScoreSync;
import StrwbryDev.scoreSync.commands.track.CommandFirstToKill;
import StrwbryDev.scoreSync.listeners.ListenerManager;
import StrwbryDev.scoreSync.utility.Config;
import StrwbryDev.scoreSync.utility.MsgUtil;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.command.CommandSender;

public class CommandReloadConfig
{
    public static LiteralCommandNode<CommandSourceStack> buildCommand(final String commandName) {
        return Commands.literal(commandName)
                .requires(sender -> sender.getSender().isOp())
                .executes(CommandReloadConfig::executeCommandLogic)
                .build();
    }

    private static int executeCommandLogic(CommandContext<CommandSourceStack> ctx){
        CommandSender sender = ctx.getSource().getSender(); // Retrieve the command sender

        MsgUtil.message(sender, String.valueOf(Config.getLastAlive()));
        //Execute command logic
        Config.reloadConfig();
        MsgUtil.message(sender, String.valueOf(Config.getLastAlive()));

        MsgUtil.message(sender,"Successfully reloaded the config!");
        return Command.SINGLE_SUCCESS;

    }
}
