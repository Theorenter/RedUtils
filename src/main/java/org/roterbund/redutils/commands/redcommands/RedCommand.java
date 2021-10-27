package org.roterbund.redutils.commands.redcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.roterbund.redutils.commands.CommandManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a command that can contain subcommands
 */
public abstract class RedCommand extends Command implements SubCommandContainer {

    private final CommandManager cmdManager;
    private final Map<String, RedSubCommand> subCommandMap;

    /*public RedCommand(@NotNull final CommandManager cmdManager, @NotNull String name) {
        super(name);

        this.cmdManager = cmdManager;
        this.subCommandMap = new HashMap<>();
    }*/

    protected RedCommand(@NotNull final CommandManager cmdManager, @NotNull final String name, final String description, final String usageMessage, final List<String> aliases) {
        super(name, description, usageMessage, aliases);

        this.cmdManager = cmdManager;
        this.subCommandMap = new HashMap<>();
    }

    /**
     * @param target Which the permission is checked
     * @return True if the goal has permissions and false if it doesn't
     */
    @Override
    public boolean testPermission(@NotNull final CommandSender target) {
        if (testPermissionSilent(target))
            return true;

        String errorMessage = cmdManager.getDontHavePermissionMsg();

        if (target instanceof Player targetPlayer) {

            if (cmdManager.getPlugin().getLocalization() != null) {
                if (getPermissionMessage() == null) {
                    errorMessage = cmdManager.getPlugin().getLocalization().getString(targetPlayer, errorMessage);
                } else {
                    errorMessage = cmdManager.getPlugin().getLocalization().getString(targetPlayer, getPermissionMessage());
                }
            } else {
                errorMessage = cmdManager.getDontHavePermissionMsg();
            }
            cmdManager.getPlugin().getNotificationManager().sendPlayerError(targetPlayer, errorMessage);
        } else {
            target.sendMessage(errorMessage);
        }
        return false;
    }

    /**
     * @return The Command Manager through which the command was registered
     */
    @SuppressWarnings("unused")
    public CommandManager getCommandManager() {
        return cmdManager;
    }

    @Override
    public void addSubCommand(@NotNull RedSubCommand subCommand) {
        subCommandMap.put(subCommand.getName(), subCommand);
    }

    @NotNull
    @Override
    public RedSubCommand getSubCommand(@NotNull String name) {
        return subCommandMap.get(name);
    }

    @Override
    public boolean hasSubCommands() {
        return subCommandMap.isEmpty();
    }

    @Override
    public boolean hasSubCommand(@NotNull String name) {
        return subCommandMap.containsKey(name);
    }

    @Override
    public Map<String, RedSubCommand> getSubCommandMap() {
        return subCommandMap;
    }

}