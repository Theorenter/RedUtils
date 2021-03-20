package org.concordiacraft.redutils.main.utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class BasedCommandManager implements CommandExecutor {
    protected HashMap<String, String> commands = new HashMap<>();

    protected String[] args;
    protected CommandSender sender;

    protected String command = "fixmewhatever";
    protected String displayName = "fixmewhatever";
    public abstract void init();
    public abstract void showHelp();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        init();

        this.args = args;
        this.sender = sender;
        if (args[0].equalsIgnoreCase("help")) {
            showHelp();
            return true;
        }
        for (String c : commands.keySet()) {
            if (c.equalsIgnoreCase(args[0])) {
                try {
                    Method method = this.getClass().getMethod(args[0].toLowerCase()+"CMD");
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
