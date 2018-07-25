/*
 * * Copyright 2018 github.com/ReflxctionDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.reflxction.opc.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.reflxction.opc.KeyNotSetException;
import net.reflxction.opc.utils.Multithreading;
import net.reflxction.opc.utils.PlayerChecker;
import net.reflxction.opc.utils.SimpleSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class which handles command input for "/online"
 */
public class OPCCommand implements ICommand {

    // Instance of the player checker
    private PlayerChecker checker = new PlayerChecker();

    /**
     * Gets the name of the command
     */
    @Override
    public String getCommandName() {
        return "online";
    }

    /**
     * Gets the usage string for the command.
     *
     * @param sender The command sender that executed the command
     */
    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/online <name>";
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add("on");
        return aliases;
    }

    /**
     * Callback when the command is invoked
     *
     * @param sender The command sender that executed the command
     * @param args   The arguments that were passed
     */
    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        switch (args.length) {
            case 1:
                new Multithreading<>().schedule((foo) -> {
                    try {
                        SimpleSender.send(checker.isOnline(args[0]) ? "&e" + args[0] + "&a is online!" : "&e" + args[0] + " &cis not online!");
                    } catch (KeyNotSetException e) {
                        SimpleSender.send("&cYou haven't set your API key yet! Do so with /api new (and it will be set automatically)");
                    }
                });
                break;
            default:
                SimpleSender.send("&cIncorrect command usage. Try " + getCommandUsage(sender));
        }
    }

    /**
     * Returns true if the given command sender is allowed to use this command.
     *
     * @param sender The command sender that executed the command
     */
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }


    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return Collections.emptyList();
    }

    /**
     * Return whether the specified command parameter index is a username parameter.
     *
     * @param args  The arguments that were passed
     * @param index Idek lul
     */
    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }


}
