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
package net.reflxction.opc.settings;

import net.reflxction.opc.OnlinePlayerChecker;

/**
 * Class which contains and manages all the mod settings (while saving it to config etc)
 */
public class Settings {

    // The Hypixel API key
    private String apiKey;

    // Assign all variables
    public Settings() {
        apiKey = OnlinePlayerChecker.getConfig().get("Key", "Key", "").getString();
    }

    /**
     * The API key
     *
     * @return The hypixel API key used to retrieve Hypixel data
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the API key and saves it to config
     *
     * @param key Key to set
     */
    public void setApiKey(String key) {
        this.apiKey = key;
        OnlinePlayerChecker.getConfig().get("Key", "Key", "").set(key);
        OnlinePlayerChecker.getConfig().save();
    }
}
