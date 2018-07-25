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
package net.reflxction.opc.utils;

/**
 * Class which contains mod information.
 */
public class Reference {

    // Mod ID (for Forge initialization)
    public static final String MOD_ID = "onlineplayerchecker";

    // Mod name
    public static final String NAME = "Online Player Checker";

    // Mod version
    public static final String VERSION = "1.0";

    // Minecraft versions that the mod works on
    public static final String ACCEPTED_VERSIONS = "[1.8.9]";

    // Mod prefix (for sending messages)
    static final String PREFIX = ChatColor.format("&a[&7OnlinePlayerChecker&a] ");

    // Client proxy handler
    public static final String CLIENT_PROXY = "net.reflxction.opc.proxy.ClientProxy";

    // Server proxy handler
    public static final String SERVER_PROXY = "net.reflxction.opc.proxy.ServerProxy";

}
