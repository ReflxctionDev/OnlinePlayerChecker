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
package net.reflxction.opc.listeners;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.reflxction.opc.OnlinePlayerChecker;
import net.reflxction.opc.utils.SimpleSender;

/**
 * Class which listens to chat message that detect the API key and sets it
 */
public class KeyListener {

    @SubscribeEvent
    public void onClientChatReceived(ClientChatReceivedEvent event) {
        String text = event.message.getUnformattedText();
        if (!text.startsWith("Your new API key is")) return;
        String[] words = text.split("\\s");
        OnlinePlayerChecker.getSettings().setApiKey(words[words.length - 1]);
        SimpleSender.send("&aYour API key has been set to &e" + words[words.length - 1]);
    }
}
