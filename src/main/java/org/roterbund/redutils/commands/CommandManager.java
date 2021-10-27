package org.roterbund.redutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.SimplePluginManager;
import org.jetbrains.annotations.NotNull;
import org.roterbund.redutils.commands.redcommands.RedCommand;
import org.roterbund.redutils.commands.redcommands.RedSubCommand;
import org.roterbund.redutils.commands.redcommands.SubCommandContainer;
import org.roterbund.redutils.main.RedPlugin;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Command management system
 */
@SuppressWarnings("unused")
public final class CommandManager {

    private final RedPlugin plugin;
    private final Map<String, Command> knownCommands;
    private String permissionUniversalMsg = "You don't have enough permissions to use this command!";

    /**
     * Constructor
     * @param plugin The plugin for which the team manager is being created
     */
    public CommandManager(@NotNull final RedPlugin plugin) {
        this.plugin = plugin;

        Map<String, Command> serverKnownCommands = null;
        try {
            SimplePluginManager spm = (SimplePluginManager) plugin.getServer().getPluginManager();
            Field scmField = spm.getClass().getDeclaredField("commandMap");
            scmField.setAccessible(true);

            SimpleCommandMap scm = (SimpleCommandMap) scmField.get(spm);
            Field knownCommandsField = scm.getClass().getSuperclass().getDeclaredField("knownCommands");
            knownCommandsField.setAccessible(true);

            //noinspection unchecked
            serverKnownCommands = (Map<String, Command>) knownCommandsField.get(scm);

            scmField.setAccessible(false);
            knownCommandsField.setAccessible(false);

            // Remove from command list commands
            // like /redcommands & /redutils:redcommands
            for (String key : plugin.getDescription().getCommands().keySet()) {
                serverKnownCommands.remove(key);
                serverKnownCommands.remove(plugin.getName().toLowerCase() + ":" + key);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            plugin.getRLogger().error(e);
        }
        this.knownCommands = serverKnownCommands;
    }

    /**
     * @param name The name of the subcommand
     */
    private void registerRedCommand(@NotNull final String name)
            throws NoSuchFieldException,
            IllegalAccessException,
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException {
        @SuppressWarnings("unchecked") Map<String, Object> redCommandMap = (Map<String, Object>) plugin.getDescription().getCommands().get("redcommands").get(name);

        RedCommand redCommand;

        String clazz = (String) redCommandMap.get("class");
        String permission = (String) redCommandMap.get("permission");
        String description = (String) redCommandMap.get("description");
        String usage = (String) redCommandMap.get("usage");
        @SuppressWarnings("unchecked") List<String> aliases = (List<String>) redCommandMap.get("aliases");
        @SuppressWarnings("unchecked") Map<String, Map<String, Object>> subCommandMap = (Map<String, Map<String, Object>>) redCommandMap.get("subcommands");

        // Get class of the RedCommand
        @SuppressWarnings("unchecked") Class<? extends RedCommand> redCommandClass = (Class<? extends RedCommand>) Class.forName(clazz);

        // Create command
        redCommand = redCommandClass.getConstructor(CommandManager.class, String.class, String.class, String.class, List.class).
                    newInstance(this, name, description, usage, aliases);
        redCommand.setPermission(permission);

        // Add subcommands
        if (subCommandMap != null && !subCommandMap.isEmpty()) {
            subCommandMap.forEach((scName, scMap) -> {
                try {
                    registerSubCommand(redCommand, scName, scMap);
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }

        // Get command map
        Field commandField = plugin.getServer().getClass().getDeclaredField("commandMap");
        commandField.setAccessible(true);
        CommandMap commandMap = (CommandMap) commandField.get(plugin.getServer());

        // Final register
        commandMap.register(name, redCommand);
    }

    /**
     * @param container The container that will contain the subcommand
     * @param name Name of the subcommand
     * @param subCommandMap Map of the subcommand from plugin.yml
     */
    private void registerSubCommand(final @NotNull SubCommandContainer container, final @NotNull String name, final @NotNull Map<String, Object> subCommandMap)
            throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            ClassNotFoundException {

        RedSubCommand subCommand;

        String clazz = (String) subCommandMap.get("class");
        String permission = (String) subCommandMap.get("permission");
        String description = (String) subCommandMap.get("description");
        String usage = (String) subCommandMap.get("usage");
        @SuppressWarnings("unchecked") Map<String, Map<String, Object>> subCommands = (Map<String, Map<String, Object>>) subCommandMap.get("subcommands");

        // Get class of the subcommand
        @SuppressWarnings("unchecked") Class<? extends RedSubCommand> subCommandClass = (Class<? extends RedSubCommand>) Class.forName(clazz);

        // Create subcommand
        subCommand = subCommandClass.getConstructor(CommandManager.class, String.class, String.class, String.class).newInstance(this, name, description, usage);
        subCommand.setPermission(permission);

        // If the subcommand contains other subcommands
        if (subCommands != null && !subCommands.isEmpty()) {
            subCommands.forEach((scName, scMap) -> {
                try {
                    registerSubCommand(subCommand, scName, scMap);
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | ClassNotFoundException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }

        // Add subcommand
        container.addSubCommand(subCommand);
    }

    /**
     * Registration of all commands and sub-commands from Plugin.yml
     */
    public void registerAllCommands() {
        // RedCommands register
        Map<String, Object> redCmdMap = plugin.getDescription().getCommands().get("redcommands");
        try {
            for (String cmdName : redCmdMap.keySet())
                registerRedCommand(cmdName);
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            plugin.getRLogger().error(e);
        }
    }

    /**
     * Removes a command from the list of all server commands
     *
     * @param name The command's name to delete
     */
    public void removeCommand(@NotNull final String name) {
        this.knownCommands.remove(name);
    }

    /**
     *
     * @param permissionUniversalMsg A link to the localization string or a message to the user that he does not have enough rights to use the command
     */
    public void setPermissionMsg(String permissionUniversalMsg) {
        this.permissionUniversalMsg = permissionUniversalMsg;
    }

    /**
     * @return A message that the user does not have enough rights to use the command
     */
    public String getPermissionMsg() {
        return permissionUniversalMsg;
    }

    /**
     * @return The plugin that the command manager belongs to
     */
    public RedPlugin getPlugin() {
        return plugin;
    }
}
