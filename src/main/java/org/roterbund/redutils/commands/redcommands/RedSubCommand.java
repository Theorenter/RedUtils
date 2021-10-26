package org.roterbund.redutils.commands.redcommands;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.roterbund.redutils.commands.CommandManager;

import java.util.HashMap;
import java.util.Map;

/**
 * A subcommand is a unique command argument that has an execution method
 */
public abstract class RedSubCommand implements SubCommandContainer {

    private final CommandManager cmdManager;

    private final String name;
    private String permission;
    private String description;
    private String usage;

    private final Map<String, RedSubCommand> subCommandMap;

    protected RedSubCommand(@NotNull final CommandManager cmdManager, final @NotNull String name, @NotNull String description, @NotNull String usage) {
        this.cmdManager = cmdManager;

        this.name = name;
        this.description = description;
        this.usage = usage;

        subCommandMap = new HashMap<>();
    }

    /**
     * @return The name of the subcommand
     */
    public String getName() {
        return name;
    }

    /**
     * @return The localization key of the subcommand description
     */
    @SuppressWarnings("unused")
    public String getDescriptionKey() {
        return description;
    }

    /**
     * @return An example of how to use the subcommand
     */
    @SuppressWarnings("unused")
    public String getUsage() {
        return usage;
    }

    /**
     * @return The permission of the subcommand
     */
    @SuppressWarnings("unused")
    public String getPermission() {
        return permission;
    }

    /**
     * @param sender The thing that ran the command
     * @param args The args passed into the command when run
     */
    @SuppressWarnings("unused")
    public abstract void execute(CommandSender sender, String[] args);

    /**
     * @param permission The permission required to execute the command
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * @param description The description of the command
     */
    @SuppressWarnings("unused")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param usage A string with the correct syntax for using the command
     */
    @SuppressWarnings("unused")
    public void setUsage(String usage) {
        this.usage = usage;
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
        subCommandMap.put(subCommand.name, subCommand);
    }

    @Override
    public boolean hasSubCommands() {
        return subCommandMap.isEmpty();
    }

    @Override
    public boolean hasSubCommand(@NotNull String name) {
        return subCommandMap.containsKey(name);
    }

    @NotNull
    @Override
    public RedSubCommand getSubCommand(@NotNull String name) {
        return subCommandMap.get(name);
    }

    @Override
    public Map<String, RedSubCommand> getSubCommandMap() {
        return subCommandMap;
    }
}