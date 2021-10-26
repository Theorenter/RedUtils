package org.roterbund.redutils.commands.redcommands;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * An interface that is implemented to command that may contain subcommands
 */
public interface SubCommandContainer {

    /**
     * Adds a subcommand to the map of subcommands
     *
     * @param subCommand The subcommand you want to add
     */
    void addSubCommand(@NotNull final RedSubCommand subCommand);

    /**
     * Displays whether a subcommand or command has a list of subcommands in it
     *
     * @return True if the SubCommandContainer implemented object has subcommands
     */
    @SuppressWarnings("unused")
    boolean hasSubCommands();

    /**
     * @param name The name of the subcommand
     * @return True if the command name passed in the parameter is present in the container
     */
    @SuppressWarnings("unused")
    boolean hasSubCommand(@NotNull final String name);

    /**
     * @param name The name of the subcommand
     * @return The subcommand or null if the subcommand is not found
     */
    @Nullable
    @SuppressWarnings("unused")
    RedSubCommand getSubCommand(@NotNull final String name);

    /**
     *
     * @return The map of subcommands
     */
    @SuppressWarnings("unused")
    Map<String, RedSubCommand> getSubCommandMap();
}
