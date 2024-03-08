package com.cluedropsound.manager;

import com.cluedropsound.utils.AudioManager;
import net.runelite.api.*;
import net.runelite.api.events.ItemSpawned;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ClueDropManager {
    private final Client client;
    private final ItemManager itemManager;
    public ClueDropManager(Client client, ItemManager itemManager, EventBus eventBus) {
        this.client = client;
        this.itemManager = itemManager;
        eventBus.register(this);
        log.info("a");
    }

    @Subscribe
    public void onItemSpawned(ItemSpawned itemSpawned) {
        int itemId = itemSpawned.getItem().getId();
        ItemComposition itemComposition = itemManager.getItemComposition(itemId);
        AudioManager audioManager = new AudioManager();
        String itemName = itemComposition.getName();

        if (itemName.toLowerCase().contains("clue")) {
            audioManager.playClip();
        }

        log.info(itemComposition.getName());
    }

}
