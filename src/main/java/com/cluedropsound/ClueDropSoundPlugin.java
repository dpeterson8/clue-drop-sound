package com.cluedropsound;

import com.cluedropsound.manager.ClueDropManager;
import com.google.inject.Provides;
import javax.inject.Inject;


import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Clue Drop Sounds"
)
public class ClueDropSoundPlugin extends Plugin
{
	@Inject
	private EventBus eventBus;
	@Inject
	private Client client;


	@Inject
	private ItemManager itemManager;

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			ClueDropManager clueDropManager = new ClueDropManager(client, itemManager,eventBus);
		}
	}


}
