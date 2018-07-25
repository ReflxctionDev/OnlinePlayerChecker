/*
 * * Copyright 2017-2018 github.com/ReflxctionDev
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
package net.reflxction.opc.utils;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import net.reflxction.opc.KeyNotSetException;
import net.reflxction.opc.OnlinePlayerChecker;

import java.io.IOException;

/**
 * A utility for doing simple checks related to players
 */
public class PlayerChecker {

    /**
     * Whether the given name is a valid player or not
     *
     * @param name Name to check for
     * @return True if the name is an available Hypixel/Minecraft player name
     * @throws KeyNotSetException if the player hasn't set a key beforehand
     */
    public boolean isPlayer(String name) throws KeyNotSetException {
        HypixelAPI api = new HypixelAPI(OnlinePlayerChecker.getSettings().getApiKey());
        try {
            api.getPlayer(name);
            return true;
        } catch (APIException e) {
            throw new KeyNotSetException();
        } catch (IOException e) {
            SimpleSender.send("&cThere are issues with the Hypixel API, thus it couldn't be determined if the player is available or not!");
        } catch (InvalidPlayerException e) {
            SimpleSender.send("&cThis player has never played here or is not available!");
        }
        return false;
    }

    /**
     * Whether the player is online or not
     *
     * @param name Player name to check
     * @return True if the given player is online, false if otherwise
     * @throws KeyNotSetException If the player hasn't set a key beforehand
     */
    public boolean isOnline(String name) throws KeyNotSetException {
        HypixelAPI api = new HypixelAPI(OnlinePlayerChecker.getSettings().getApiKey());
        try {
            HypixelPlayer player = api.getPlayer(name);
            return player.getLastLogin() > player.getLastLogout();
        } catch (APIException e) {
            throw new KeyNotSetException();
        } catch (IOException e) {
            SimpleSender.send("&cThere are issues with the Hypixel API, thus it couldn't be determined if the player is available or not!");
        } catch (InvalidPlayerException e) {
            SimpleSender.send("&cThis player has never played here or is not available!");
        }
        return false;
    }
}
