package org.concordiacraft.redutils.commands;

import com.sun.istack.internal.NotNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.concordiacraft.redutils.main.RedUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author Nicekita, Theorenter
 */
public abstract class RedCommand implements CommandExecutor {
    protected HashMap<String, String> commands = new HashMap<>();

    protected String[] args;
    protected CommandSender sender;

    protected String command = "fixmewhatever";
    protected String displayName = "fixmewhatever";
    public abstract void init();

    @NotNull
    public abstract void showHelp();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        init();

        this.args = args;
        this.sender = sender;

        RedUtils.getPlugin().getRedLogger().debug("Command args: ");
        RedUtils.getPlugin().getRedLogger().debug(args.toString());

        if ((args.length == 0) || (args[0].equalsIgnoreCase("help"))) {
            showHelp();
            return true;
        }
        RedUtils.getPlugin().getRedLogger().debug("commands.keys: ");
        for (String c : commands.keySet()) {
            RedUtils.getPlugin().getRedLogger().debug(c);
            if (c.equalsIgnoreCase(args[0])) {
                try {
                    String com = args[0];
                    if (args[0].contains(" ")) {
                        com = args[0].replaceAll(" ", "_");
                    }
                    Method method = this.getClass().getMethod(com.toLowerCase()+"CMD");
                    try {
                        method.invoke(this);
                        return true;
                    }
                    catch (IllegalAccessException | IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                    catch (InvocationTargetException e) {
                            e.getCause().printStackTrace();
                    }

                }
                catch (NoSuchMethodException e) {
                    showHelp();
                }
            }
        }
        return false;
    }
    public void showBasicHelp() {
        //todo Basic help info
    }
}
